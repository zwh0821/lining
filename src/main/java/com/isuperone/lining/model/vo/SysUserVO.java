package com.isuperone.lining.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.isuperone.lining.model.entity.sys.SysUser;

/**
 * @program: Lining
 * @description: SysUser view Object
 * @author: Joe
 * @create: 2020-05-11 17:36
 **/
public class SysUserVO extends SysUser {

    private String roleName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
