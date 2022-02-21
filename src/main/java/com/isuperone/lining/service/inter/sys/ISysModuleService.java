package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.vo.SysModuleVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysModuleService extends IService<SysModule> {


    int saveModule(SysModule sysModule) throws Exception;

    void removeModule(SysModule sysModule) throws Exception;

    Page<SysModule> findModulePage(Page<SysModule> page, SysModule sysModule);

    Page<SysModuleVO> findMenuPage(Page<SysModuleVO> page, SysModule sysModule);

    List<SysModule> findModuleList(SysModule sysModule);

    SysModuleVO getMenu(SysModule sysmodule);

}
