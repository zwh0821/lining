package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.mapper.sys.SysOperationLogMapper;
import com.isuperone.lining.model.entity.sys.SysOperationLog;
import com.isuperone.lining.model.vo.sys.SysOperationLogVO;
import com.isuperone.lining.service.inter.sys.ISysOperationLogService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

    @Override
    public int saveOperationLog(SysOperationLog operationLog) {
        return this.baseMapper.insert(operationLog);
    }

    @Override
    public int removeOperationLog(SysOperationLog operationLog) {
        return this.baseMapper.deleteById(operationLog);
    }

    @Override
    public Page<SysOperationLogVO> findOperationLogPage(Page<SysOperationLogVO> page, SysOperationLog log,Map<String, Object> map) {
        return this.baseMapper.findSysOperationLogPage(page,log,map );
    }

}
