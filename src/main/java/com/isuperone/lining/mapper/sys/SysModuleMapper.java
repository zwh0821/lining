package com.isuperone.lining.mapper.sys;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isuperone.lining.model.vo.SysModuleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface SysModuleMapper extends BaseMapper<SysModule> {

    @ResultMap("MenuResultMap")
    Page<SysModuleVO> findMenuPage(Page<SysModuleVO> page, SysModule sysModule);

    @ResultMap("MenuResultMap")
    SysModuleVO getMenu(@Param("module") SysModule sysModule);
}
