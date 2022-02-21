package com.isuperone.lining.model.vo.sys;

import com.isuperone.lining.model.entity.sys.SysRole;

import java.util.List;

/**
 * @program: Lining
 * @description: 角色 ViewObject
 * @author: Joe
 * @create: 2020-07-08 17:11
 **/
public class SysRoleVO extends SysRole {

    private List<PermissionVO> permissions;

    public List<PermissionVO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVO> permissions) {
        this.permissions = permissions;
    }
}
