package com.isuperone.lining.service.inter.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.qo.task.BizTaskQO;
import com.isuperone.lining.model.vo.index.IndexDataVO;
import com.isuperone.lining.model.vo.task.BizTaskVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface IBizTaskService extends IService<BizTask> {

    void saveBizTask(BizTask bizTask);

    int removeBizTask(BizTask bizTask);

    int startBizTask(BizTask bizTask);

    int submitBizTask(BizTaskQO bizTask);

    int auditBizTask(BizTaskQO bizTask);

    int approveBizTask(BizTaskQO bizTask);

    int rejectBizTask(BizTaskQO bizTask);

    int finishBizTask(BizTask bizTask);

    BizTaskVO getBizTask(BizTask bizTask);

    Page<BizTaskVO> findBizTaskPage(Page<BizTaskVO> page, BizTaskVO bizTaskVO, Map<String, Object> map);

    List<BizTask> findBizTaskList(BizTask bizTask);

    List<BizTaskVO> getBizTaskExcel(List<Long> ids);

    IndexDataVO getIndexDataVo();

}
