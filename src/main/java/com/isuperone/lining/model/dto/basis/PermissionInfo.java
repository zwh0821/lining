package com.isuperone.lining.model.dto.basis;

import com.isuperone.lining.model.vo.sys.ActionVO;

import java.util.List;

/**
 * @program: Lining
 * @description: 权限信息
 * @author: Joe
 * @create: 2020-04-22 14:38
 **/
public class PermissionInfo {

    public String permissionId;

    public String roleId;

    public String permissionName;

    public String actions;

    public List<ActionVO> actionEntitySet;

}
