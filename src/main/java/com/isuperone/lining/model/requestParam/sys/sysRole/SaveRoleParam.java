package com.isuperone.lining.model.requestParam.sys.sysRole;

import com.isuperone.lining.model.dto.system.PermissionDto;
import com.isuperone.lining.model.entity.sys.SysRole;

import java.util.List;

/**
 * @program: qichebao
 * @description: 保存角色参数
 * @author: Joe
 * @create: 2020-07-29 14:50
 **/
public class SaveRoleParam extends SysRole {

    private List<PermissionDto> permissionDtoList;

    public List<PermissionDto> getPermissionDtoList() {
        return permissionDtoList;
    }

    public void setPermissionDtoList(List<PermissionDto> permissionDtoList) {
        this.permissionDtoList = permissionDtoList;
    }

}
