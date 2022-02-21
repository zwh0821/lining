package com.isuperone.lining.service.inter.sys;

import com.isuperone.lining.model.entity.sys.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    void saveSysUserRole(SysUserRole sysUserRole);

    void removeSysUserRole(SysUserRole sysUserRole);

}
