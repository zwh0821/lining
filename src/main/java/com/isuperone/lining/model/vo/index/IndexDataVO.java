package com.isuperone.lining.model.vo.index;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.List;

/**
 * @program: Lining
 * @description: 首页数据类型
 * @author: Joe
 * @create: 2020-06-16 18:29
 **/
public class IndexDataVO {

    @ApiModelProperty(value = "项目总数")
    public int projectNum;

    @ApiModelProperty(value = "工点数量")
    public int constructionPointNum;

    @ApiModelProperty(value = "工单数量数量")
    public int faultOrderNum;

    @ApiModelProperty(value = "任务数量")
    public int taskNum;

    @ApiModelProperty(value = "工单状态统计")
    public List<HashMap<String,Object>> statusStatistics;

    @ApiModelProperty(value = "任务按项目统计")
    public List<HashMap<String,Object>> taskStatisticsByPorject;

    @ApiModelProperty(value = "任务按月统计")
    public List<HashMap<String,Object>> taskStatisticsByMonth;

    public int getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
    }

    public int getConstructionPointNum() {
        return constructionPointNum;
    }

    public void setConstructionPointNum(int constructionPointNum) {
        this.constructionPointNum = constructionPointNum;
    }

    public int getFaultOrderNum() {
        return faultOrderNum;
    }

    public void setFaultOrderNum(int faultOrderNum) {
        this.faultOrderNum = faultOrderNum;
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }

    public List<HashMap<String, Object>> getStatusStatistics() {
        return statusStatistics;
    }

    public void setStatusStatistics(List<HashMap<String, Object>> statusStatistics) {
        this.statusStatistics = statusStatistics;
    }

    public List<HashMap<String, Object>> getTaskStatisticsByPorject() {
        return taskStatisticsByPorject;
    }

    public void setTaskStatisticsByPorject(List<HashMap<String, Object>> taskStatisticsByPorject) {
        this.taskStatisticsByPorject = taskStatisticsByPorject;
    }

    public List<HashMap<String, Object>> getTaskStatisticsByMonth() {
        return taskStatisticsByMonth;
    }

    public void setTaskStatisticsByMonth(List<HashMap<String, Object>> taskStatisticsByMonth) {
        this.taskStatisticsByMonth = taskStatisticsByMonth;
    }
}
