package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.dto.system.SysRoleDto;
import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.requestParam.sys.sysRole.SaveRoleParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysRoleService extends IService<SysRole> {

    int saveRole(SaveRoleParam role) throws Exception;

    void removeRole(SysRole role) throws Exception;

    Page<SysRole> findRolePage(Page<SysRole> page, SysRole sysRole);

    List<SysRole> findRoleList(SysRole sysRole);

    SysRoleDto getRoleInfo(SysRole sysRole);
}
