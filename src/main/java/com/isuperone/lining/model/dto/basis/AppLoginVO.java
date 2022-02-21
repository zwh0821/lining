package com.isuperone.lining.model.dto.basis;

import com.isuperone.lining.model.entity.sys.SysUser;

/**
 * @program: Lining
 * @description: app登录返回对象
 * @author: Joe
 * @create: 2021-09-08 05:35
 **/
public class AppLoginVO extends SysUser {

    private String roleCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
