package com.isuperone.lining.service.inter.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.dto.task.TaskFilterConditionDto;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.vo.project.BizProjectVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface IBizProjectService extends IService<BizProject> {

    void saveBizProject(BizProject bizProject);

    void removeBizProject(BizProject bizProject);

    BizProjectVO getBizProject(BizProject bizProject);

    Page<BizProjectVO> findBizProjectPage(Page<BizProjectVO> page, BizProject bizProject);

    List<BizProject> findBizProjectList(BizProject bizProject);

    int getBizProjectSum(TaskFilterConditionDto conditionDto);


}
