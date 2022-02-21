package com.isuperone.lining.model.dto.system;

import com.isuperone.lining.model.vo.sys.ActionVO;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-07-08 15:23
 **/
public class PermissionDto {

    private String permissionId;

    private String name;

    private List<ActionDto> actionData;

    private List<PermissionDto> children;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActionDto> getActionData() {
        return actionData;
    }

    public void setActionData(List<ActionDto> actionData) {
        this.actionData = actionData;
    }

    public List<PermissionDto> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionDto> children) {
        this.children = children;
    }

}
