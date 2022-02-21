package com.isuperone.lining.service.impl.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.constant.Constants;
import com.isuperone.lining.common.enumration.FunctionCodeEnum;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.biz.BizTaskTerminalDataMapper;
import com.isuperone.lining.model.dto.common.TreeDto;
import com.isuperone.lining.model.dto.task.VerifyResult;
import com.isuperone.lining.model.entity.biz.*;
import com.isuperone.lining.model.qo.task.BizTaskQO;
import com.isuperone.lining.model.qo.task.TerminalDataQO;
import com.isuperone.lining.model.vo.task.BizTaskVO;
import com.isuperone.lining.model.vo.task.TaskDataVO;
import com.isuperone.lining.service.inter.biz.*;
import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class BizTaskTerminalDataServiceImpl extends ServiceImpl<BizTaskTerminalDataMapper, BizTaskTerminalData> implements IBizTaskTerminalDataService {

    @Override
    public HashMap<String, String> importBizTaskTerminalData(TerminalDataQO terminalData) throws DecoderException {
        return null;
    }

    @Override
    public List<TreeDto> getProjectTree() {
        return null;
    }

    @Override
    public TaskDataVO getBizTaskTerminalData(BizTask bizTask) {
        return null;
    }
}
