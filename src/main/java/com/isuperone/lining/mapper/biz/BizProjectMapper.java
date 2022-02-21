package com.isuperone.lining.mapper.biz;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.dto.task.TaskFilterConditionDto;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.vo.project.BizProjectVO;
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
public interface BizProjectMapper extends BaseMapper<BizProject> {

    Page<BizProjectVO> findProjectPage(Page<BizProjectVO> page, @Param("project") BizProject project);

    BizProjectVO getProjectInfo(@Param("project") BizProject bizProject);

    int getProjectNum(@Param("condition") TaskFilterConditionDto conditionDto);

    List<BizProject> findBizProjectList(@Param("project") BizProject bizProject,@Param("condition") TaskFilterConditionDto conditionDto);
}
