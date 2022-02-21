package com.isuperone.lining.service.impl.sys;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.PositionEnum;
import com.isuperone.lining.common.enumration.StatusEnums;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.common.helper.CurrentUserUtil;
import com.isuperone.lining.common.helper.TokenUtil;
import com.isuperone.lining.mapper.sys.SysUserMapper;
import com.isuperone.lining.model.dto.LoginDto;
import com.isuperone.lining.model.dto.basis.*;
import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.entity.sys.SysRolePermission;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.entity.sys.SysUserRole;
import com.isuperone.lining.model.qo.LoginQo;
import com.isuperone.lining.model.vo.SysUserVO;
import com.isuperone.lining.model.vo.sys.ActionVO;
import com.isuperone.lining.service.inter.sys.ISysRolePermissionService;
import com.isuperone.lining.service.inter.sys.ISysRoleService;
import com.isuperone.lining.service.inter.sys.ISysUserRoleService;
import com.isuperone.lining.service.inter.sys.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: Lining
 * @description: 用户Service
 * @author: Joe
 * @create: 2020-03-27 15:52
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    ISysUserRoleService sysUserRoleService;

    @Resource
    ISysRoleService sysRoleService;

    @Resource
    ISysRolePermissionService sysRolePermissionService;

    @Override
    public LoginDto login(LoginQo para) throws Exception {
        // 构造实体对应的 EntityWrapper 对象，进行过滤查询
        QueryWrapper<SysUser> ew = new QueryWrapper<SysUser>();
        ew.eq("username", para.username).eq("password", para.password);
        ew.eq("status", StatusEnums.systemStatus_enable.getCode());
        SysUser user = this.getOne(ew);
        if (user != null) {
            LoginDto loginDto = new LoginDto();
            loginDto.setId(user.id);
            loginDto.setCreateTime(user.createTime);
            loginDto.setLastLoginIp(user.lastLoginIp);
            loginDto.setLastLoginTime(user.lastLoginTime);
            loginDto.setName(user.name);
            loginDto.setUsername(user.username);
            loginDto.setMerchantCode(user.merchantCode);
            loginDto.setTelephone(user.telephone);
            loginDto.setStatus(user.status);
            loginDto.setToken(TokenUtil.getToken(user));
            return loginDto;
        } else {
            throw new Exception("登陆失败，账号或密码错误");
        }
    }

    @Override
    public void saveUser(SysUserVO sysUserVO) throws ServiceException {
        //判断是否有重名
        QueryWrapper<SysUser> ew = new QueryWrapper<SysUser>();
        ew.eq("username", sysUserVO.getUsername());
        ew.ne("status", StatusEnums.systemStatus_deleted.getCode());
        //判断是否有重复绑定的人员
        QueryWrapper<SysUser> staffEW = new QueryWrapper<>();
        Long id = sysUserVO.getId();
        if (id != null) {
            ew.ne("id", id);
            staffEW.ne("id", id);
        }
        List<SysUser> query = this.baseMapper.selectList(ew);
        List<SysUser> sysUsers = this.baseMapper.selectList(staffEW);
        if (query.size() > 0) {
            throw new ServiceException("已存在用户登录名为" + sysUserVO.getUsername() + "的用户");
        }
        if (sysUsers.size() > 0) {
            throw new ServiceException("所绑定的人员已被其他账号绑定");
        }
        if (sysUserVO.getStatus() == null) {
            sysUserVO.setStatus(1);
        }
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setRoleId(sysUserVO.getRoleId());
        sysUserRole.setUserId(sysUserVO.getId());
        if (id == null) {
            sysUserVO.setCreateTime(new Date());
            this.baseMapper.insert(sysUserVO);
        } else {
            this.baseMapper.updateById(sysUserVO);
        }
        sysUserRole.setUserId(sysUserVO.getId());
        sysUserRole.setStatus(StatusEnums.systemStatus_enable.getCode());
        this.sysUserRoleService.saveSysUserRole(sysUserRole);
    }

    @Override
    public Page<SysUserVO> findUserPage(Page<SysUserVO> page, SysUser sysUser) {
        return this.baseMapper.findUserPage(page, sysUser);
    }

    @Override
    public SysUserVO getUserInfo(SysUserVO sysUserVO) {
        if (sysUserVO.getId() != null) {
            return this.baseMapper.getUserInfo(sysUserVO);
        } else {
            throw new ServiceException("未获取到用户Id");
        }
    }

    @Override
    public void removeUser(SysUserVO sysUserVo) {
        if (sysUserVo.getRoleId() == null || sysUserVo.getId() == null) {
            throw new ServiceException("获取用户信息参数失败");
        }
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUserVo.getId());
        sysUserRole.setRoleId(sysUserVo.getRoleId());
        SysUser sysUser = this.getById(sysUserVo);
        sysUser.setStatus(StatusEnums.systemStatus_deleted.getCode());
        try {
            this.sysUserRoleService.removeSysUserRole(sysUserRole);
            this.baseMapper.deleteById(sysUserVo.getId());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public UserPositionInfoDto getPositonInfo(Long userId) {
        if (userId != null) {
            return this.baseMapper.getPositonInfo(userId);
        } else {
            throw new ServiceException("未获取到用户Id");
        }
    }

    @Override
    public UserInfo userLoginInfo() {
        UserLoginInfo user = CurrentUserUtil.getCurrentUser();
        UserInfo userInfo = new UserInfo();
        SysUser sysUser = user.getUser();

        userInfo.id = sysUser.getId();
        userInfo.username = sysUser.getUsername();
        userInfo.name = sysUser.getName();
        userInfo.telephone = sysUser.getTelephone();
        userInfo.createTime = new Date();

        QueryWrapper<SysUserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.eq("userId", sysUser.getId());
        userRoleQueryWrapper.eq("status", StatusEnums.systemStatus_enable.getCode());
        SysUserRole userRole = this.sysUserRoleService.getOne(userRoleQueryWrapper);
        userInfo.setRoleId(userRole.getRoleId());

        RoleInfo roleInfo = new RoleInfo();
        SysRole sysRole = this.sysRoleService.getById(userRole.getRoleId());
        roleInfo.setId(sysRole.getId().toString());
        roleInfo.setCreateTime(sysRole.getCreateTime());
        roleInfo.setDescribe(sysRole.getDescription());
        roleInfo.setName(sysRole.getName());
        roleInfo.setStatus(sysRole.getStatus());


        List<PermissionInfo> permissionInfoList = new ArrayList<>();
        QueryWrapper<SysRolePermission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq("roleId", sysRole.getId());
        List<SysRolePermission> permissions = this.sysRolePermissionService.list(permissionQueryWrapper);
        permissions.forEach(p -> {
            PermissionInfo permissionInfo = new PermissionInfo();
            permissionInfo.roleId = p.getRoleId().toString();
            permissionInfo.permissionId = p.getPermissionId();
            String actionEntity = p.getActionEntity();
            if (StringUtils.isNotEmpty(actionEntity)) {
                List<ActionVO> actionList = JSONUtil.toList(JSONUtil.parseArray(p.getActionEntity()), ActionVO.class);
                permissionInfo.actionEntitySet = actionList;
            }
            permissionInfoList.add(permissionInfo);
        });

        roleInfo.permissions = permissionInfoList;
        userInfo.role = roleInfo;
        return userInfo;
    }

    @Override
    public AppLoginVO appLogin(LoginQo para) throws Exception {
        // 构造实体对应的 EntityWrapper 对象，进行过滤查询
        QueryWrapper<SysUser> ew = new QueryWrapper<SysUser>();
        ew.eq("username", para.username).eq("password", para.password);
        ew.eq("status", StatusEnums.systemStatus_enable.getCode());
        SysUser user = this.getOne(ew);
        if (user != null) {
            QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId",user.getId());
            queryWrapper.eq("status",StatusEnums.systemStatus_enable.getCode());
            SysUserRole userRole = sysUserRoleService.getOne(queryWrapper);
            if (userRole == null) {
                throw new Exception("登陆失败，账号或密码错误");
            }
            SysRole sysRole = this.sysRoleService.getById(userRole.getRoleId());
            if (sysRole == null) {
                throw new Exception("登陆失败，账号或密码错误");
            }
            AppLoginVO result = new AppLoginVO();
            BeanUtils.copyProperties(user,result);
            result.setRoleCode(sysRole.getRoleCode());
            return result;
        } else {
            throw new Exception("登陆失败，账号或密码错误");
        }
    }
}
