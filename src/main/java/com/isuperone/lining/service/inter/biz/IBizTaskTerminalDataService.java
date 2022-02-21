package com.isuperone.lining.service.inter.biz;

import com.isuperone.lining.model.dto.common.TreeDto;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.entity.biz.BizTaskTerminalData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.qo.task.TerminalDataQO;
import com.isuperone.lining.model.vo.task.TaskDataVO;
import org.apache.commons.codec.DecoderException;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface IBizTaskTerminalDataService extends IService<BizTaskTerminalData> {

    HashMap<String,String> importBizTaskTerminalData(TerminalDataQO terminalData) throws DecoderException;

    List<TreeDto> getProjectTree();

    TaskDataVO getBizTaskTerminalData(BizTask bizTask);

}
