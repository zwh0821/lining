package com.isuperone.lining.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.entity.sys.SysOperationLog;
import com.isuperone.lining.model.vo.sys.SysOperationLogVO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface SysOperationLogMapper extends BaseMapper<SysOperationLog> {

    Page<SysOperationLogVO> findSysOperationLogPage(Page<SysOperationLogVO> page, @Param("log") SysOperationLog log ,@Param("map") Map<String, Object> map);

}
