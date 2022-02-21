package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isuperone.lining.common.enumration.StatusEnums;
import com.isuperone.lining.model.entity.sys.SysUserRole;
import com.isuperone.lining.mapper.sys.SysUserRoleMapper;
import com.isuperone.lining.service.inter.sys.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {


    @Override
    public void saveSysUserRole(SysUserRole sysUserRole) {
        QueryWrapper<SysUserRole> wrapper = new QueryWrapper<>();
        if(sysUserRole.getUserId() != null){
            wrapper.eq("userId",sysUserRole.getUserId());
        }
        wrapper.eq("status",sysUserRole.getStatus());
        List<SysUserRole> sysUserRoles = this.baseMapper.selectList(wrapper);
        sysUserRole.setStatus(StatusEnums.systemStatus_enable.getCode());
        if(sysUserRoles.size() > 0 ){
            //如果有的话，则更新
            SysUserRole userRole = sysUserRoles.get(0);
            sysUserRole.setId(userRole.getId());
            this.baseMapper.updateById(sysUserRole);
        }else{
            sysUserRole.setCreateTime(new Date());
            this.baseMapper.insert(sysUserRole);
        }
    }

    @Override
    public void removeSysUserRole(SysUserRole sysUserRole) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId",sysUserRole.getRoleId());
        queryWrapper.eq("userId",sysUserRole.getUserId());
        queryWrapper.ne("status",StatusEnums.systemStatus_deleted.getCode());
        List<SysUserRole> list = this.baseMapper.selectList(queryWrapper);
        if(list.size() > 0){
            sysUserRole = list.get(0);
            sysUserRole.setStatus(StatusEnums.systemStatus_deleted.getCode());
            this.baseMapper.updateById(sysUserRole);
        }
    }
}
