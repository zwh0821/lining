package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.entity.sys.SysOperationLog;
import com.isuperone.lining.model.vo.sys.SysOperationLogVO;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface ISysOperationLogService extends IService<SysOperationLog> {

    int saveOperationLog(SysOperationLog operationLog);

    int removeOperationLog(SysOperationLog operationLog);

    Page<SysOperationLogVO> findOperationLogPage(Page<SysOperationLogVO> page,SysOperationLog log, Map<String, Object> hashMap);

}
