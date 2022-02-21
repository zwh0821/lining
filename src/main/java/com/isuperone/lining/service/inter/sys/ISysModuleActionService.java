package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.dto.system.PermissionDto;
import com.isuperone.lining.model.dto.system.SysModuleActionDto;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.entity.sys.SysModuleAction;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysModuleActionService extends IService<SysModuleAction> {

    Page<SysModuleActionDto> findModuleActionPage(Page<SysModuleActionDto> page, SysModule sysModule);

    void saveModuleAction(SysModuleActionDto sysModuleActionDto);

    List<PermissionDto> getPermissonData();
}
