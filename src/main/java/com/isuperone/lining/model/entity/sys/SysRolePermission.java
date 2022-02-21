package com.isuperone.lining.model.entity.sys;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("roleId")
    private Long roleId;

    /**
     * 模块id
     */
    @TableField("permissionId")
    private String permissionId;

    /**
     * 模块id
     */
    @TableField("name")
    private String name;


    /**
     * 状态
     */
    private Integer status;

    /**
     * action的json数据，格式如：[{'action': 'get','describe': '详情', 'defaultCheck': false}]
     */
    @TableField("actionEntity")
    private String actionEntity;

    @TableField("createTime")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getActionEntity() {
        return actionEntity;
    }

    public void setActionEntity(String actionEntity) {
        this.actionEntity = actionEntity;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
        "roleId=" + roleId +
        ", permissionId=" + permissionId +
        ", status=" + status +
        ", actionEntity=" + actionEntity +
        ", createTime=" + createTime +
        "}";
    }
}
