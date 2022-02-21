package com.isuperone.lining.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.dto.system.SysModuleActionDto;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.entity.sys.SysModuleAction;
import com.isuperone.lining.model.vo.SysModuleActionVo;
import com.isuperone.lining.model.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface SysModuleActionMapper extends BaseMapper<SysModuleAction> {

    Page<SysModuleActionDto> findModuleActionPage(Page<SysModuleActionDto> page, @Param("sysModule") SysModule sysModule);

    List<SysModuleActionDto> findModuleActionList(@Param("sysModule") SysModule sysModule);
}
