package com.isuperone.lining.model.dto.system;

import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.vo.sys.ActionVO;
import com.isuperone.lining.model.vo.sys.PermissionVO;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-07-08 12:29
 **/
public class SysRoleDto extends SysRole {

    private List<PermissionDto> permissions;

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
