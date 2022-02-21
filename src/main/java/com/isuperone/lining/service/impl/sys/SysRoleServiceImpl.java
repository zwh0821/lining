package com.isuperone.lining.service.impl.sys;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.StatusEnums;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.sys.SysRoleMapper;
import com.isuperone.lining.model.dto.system.ActionDto;
import com.isuperone.lining.model.dto.system.PermissionDto;
import com.isuperone.lining.model.dto.system.SysRoleDto;
import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.entity.sys.SysRolePermission;
import com.isuperone.lining.model.requestParam.sys.sysRole.SaveRoleParam;
import com.isuperone.lining.service.inter.sys.ISysRolePermissionService;
import com.isuperone.lining.service.inter.sys.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private ISysRolePermissionService sysRolePermissionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRole(SaveRoleParam sysRoleDto) throws Exception {
        Date now = new Date();
        QueryWrapper<SysRole> ew = new QueryWrapper<SysRole>();
        ew.eq("name", sysRoleDto.getName());
        ew.eq("roleCode", sysRoleDto.getRoleCode());
        ew.ne("status", StatusEnums.systemStatus_deleted.getCode());
        if (sysRoleDto.getId() != null) {
            ew.ne("id", sysRoleDto.getId());
        }
        List<SysRole> query = this.baseMapper.selectList(ew);
        if (query.size() > 0) {
            throw new Exception("已存在名为" + sysRoleDto.getName() + "的角色或唯一识别码为" + sysRoleDto.getRoleCode() + "的唯一码");
        }
        SysRole sysRole = new SysRole();
        sysRole.setName(sysRoleDto.getName());
        sysRole.setRoleCode(sysRoleDto.getRoleCode());
        sysRole.setCreateTime(now);
        sysRole.setDescription(sysRoleDto.getDescription());
        sysRole.setStatus(sysRoleDto.getStatus());
        List<PermissionDto> permissionDtos = sysRoleDto.getPermissionDtoList();
        //新增
        if (sysRoleDto.getId() == null) {
            int result = this.baseMapper.insert(sysRole);
            this.handlerSysRolePermission(sysRole.getId(), permissionDtos, now);
            return result;
        }
        //修改
        this.handlerSysRolePermission(sysRoleDto.getId(), permissionDtos, now);
        return baseMapper.updateById(sysRole);
    }

    @Override
    public void removeRole(SysRole role) throws Exception {
        if (role.getId() != null && role.getId() != 0) {
            SysRole sysRole = this.getById(role.getId());
            if (sysRole != null) {
                sysRole.setStatus(StatusEnums.systemStatus_deleted.getCode());
                this.updateById(sysRole);
            } else {
                throw new ServiceException("未找到对应的角色");
            }
        }
    }

    @Override
    public Page<SysRole> findRolePage(Page<SysRole> page, SysRole sysRole) {
        QueryWrapper<SysRole> queryWrapper = this.getWrapper(sysRole);
        this.baseMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public List<SysRole> findRoleList(SysRole sysRole) {
        QueryWrapper<SysRole> queryWrapper = this.getWrapper(sysRole);
        List<SysRole> sysRoles = this.baseMapper.selectList(queryWrapper);
        return sysRoles;
    }

    @Override
    public SysRoleDto getRoleInfo(SysRole sysRole) {
        SysRoleDto sysRoleDto = new SysRoleDto();
        if (sysRole.getId() == null) {
            throw new ServiceException("获取该角色信息失败");
        }
        SysRole role = this.getById(sysRole.getId());
        if (role != null) {
            sysRoleDto.setId(role.getId());
            sysRoleDto.setRoleCode(role.getRoleCode());
            sysRoleDto.setName(role.getName());
            sysRoleDto.setStatus(role.getStatus());
            sysRoleDto.setDescription(role.getDescription());
            sysRoleDto.setCreateTime(role.getCreateTime());
            QueryWrapper<SysRolePermission> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("roleId", role.getId());
            List<SysRolePermission> permissions = this.sysRolePermissionService.list(queryWrapper);
            List<PermissionDto> permissionDtoList = new ArrayList<>();
            permissions.forEach(p -> {
                PermissionDto permissionDto = new PermissionDto();
                List<ActionDto> actionVOList = JSONUtil.toList(JSONUtil.parseArray(p.getActionEntity()), ActionDto.class);
                permissionDto.setPermissionId(p.getPermissionId().toString());
                permissionDto.setName(p.getName());
                permissionDto.setActionData(actionVOList);
                permissionDtoList.add(permissionDto);
            });
            sysRoleDto.setPermissions(permissionDtoList);
        } else {
            throw new ServiceException("获取该角色信息失败");
        }
        return sysRoleDto;
    }

    public QueryWrapper<SysRole> getWrapper(SysRole sysRole) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>();
        if (sysRole != null) {
            if (StringUtils.isNotEmpty(sysRole.getName())) {
                queryWrapper.like("name", sysRole.getName());
            }
            if (StringUtils.isNotEmpty(sysRole.getDescription())) {
                queryWrapper.like("description", sysRole.getDescription());
            }
            if (sysRole.getStatus() != null) {
                queryWrapper.eq("status", sysRole.getStatus());
            } else {
                queryWrapper.ne("status", StatusEnums.systemStatus_deleted.getCode());
            }
        }
        return queryWrapper;
    }

    public void handlerSysRolePermission(Long roleId, List<PermissionDto> permissionDtos, Date now) {
        QueryWrapper<SysRolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId", roleId);
        List<SysRolePermission> addList = new ArrayList<>();
        List<SysRolePermission> permissions = this.sysRolePermissionService.list(queryWrapper);
        //如果权限列表为空
        if (permissionDtos == null || permissionDtos.size() == 0) {
            if (permissions.size() > 0) {
                this.sysRolePermissionService.removeByIds(permissions);
            }
            return;
        } else {
            //权限列表不为空
            if (permissions.size() == 0) {
                permissionDtos.forEach(s -> {
                    SysRolePermission sysRolePermission = new SysRolePermission();
                    List<ActionDto> actionData = s.getActionData();
                    String actionEntity = JSONUtil.toJsonStr(actionData);
                    sysRolePermission.setCreateTime(now);
                    sysRolePermission.setActionEntity(actionEntity);
                    sysRolePermission.setPermissionId(s.getPermissionId());
                    sysRolePermission.setRoleId(roleId);
                    sysRolePermission.setName(s.getName());
                    addList.add(sysRolePermission);
                });
                this.sysRolePermissionService.saveBatch(addList, addList.size());
            } else {
                permissionDtos.forEach(s -> {
                    Optional<SysRolePermission> queryResult = permissions.stream().filter(f -> f.getPermissionId().equals(s.getPermissionId())).findFirst();
                    if (queryResult.isPresent()) {
                        //如果原本已经存在
                        SysRolePermission sysRolePermission = new SysRolePermission();
                        List<ActionDto> actionData = s.getActionData();
                        String actionEntity = JSONUtil.toJsonStr(actionData);
                        sysRolePermission.setCreateTime(now);
                        sysRolePermission.setActionEntity(actionEntity);
                        sysRolePermission.setId(queryResult.get().getId());
                        sysRolePermission.setPermissionId(s.getPermissionId());
                        sysRolePermission.setRoleId(roleId);
                        sysRolePermission.setName(s.getName());
                        addList.add(sysRolePermission);
                    } else {
                        //如果原本不存在
                        SysRolePermission sysRolePermission = new SysRolePermission();
                        List<ActionDto> actionData = s.getActionData();
                        String actionEntity = JSONUtil.toJsonStr(actionData);
                        sysRolePermission.setCreateTime(now);
                        sysRolePermission.setActionEntity(actionEntity);
                        sysRolePermission.setPermissionId(s.getPermissionId());
                        sysRolePermission.setRoleId(roleId);
                        sysRolePermission.setName(s.getName());
                        addList.add(sysRolePermission);
                    }

                });
                this.sysRolePermissionService.saveOrUpdateBatch(addList, addList.size());
            }
        }


    }

}
