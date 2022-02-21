package com.isuperone.lining.mapper.biz;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.dto.task.TaskFilterConditionDto;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.vo.task.BizTaskVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public interface BizTaskMapper extends BaseMapper<BizTask> {

    BizTaskVO getBizTaskInfo(@Param("task") BizTask bizTask);

    Page<BizTaskVO> findBizTaskPage(Page<BizTaskVO> page, @Param("task") BizTaskVO bizTaskVO, @Param("map") Map<String, Object> map);

    List<BizTaskVO> findExcelList(@Param("ids")List<Long> ids);

    Integer getPropertySum(@Param("task")BizTask bizTask,@Param("property")String coloum);

    Integer getTaskSumByProject(@Param("condition")TaskFilterConditionDto conditionDto);

    List<HashMap<String,Object>> getTaskProjectGroup(@Param("condition")TaskFilterConditionDto conditionDto);

    List<HashMap<String,Object>> getTaskMonGroup(@Param("condition")TaskFilterConditionDto conditionDto);
}
