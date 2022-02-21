package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.entity.sys.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysConfigService extends IService<SysConfig> {

    int saveSysConfig(SysConfig sysConfig);

    int removeSysConfig(SysConfig sysConfig);

    Page<SysConfig> findSysConfigPage(Page<SysConfig> page, SysConfig sysConfig);

    List<SysConfig> findSysConfigList(SysConfig sysConfig);

    SysConfig getConfigByConfigKey(String confgiKey);
}
