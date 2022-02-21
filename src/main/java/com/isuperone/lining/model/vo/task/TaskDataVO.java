package com.isuperone.lining.model.vo.task;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Lining
 * @description: 任务数据view Object
 * @author: Joe
 * @create: 2020-05-25 17:05
 **/
public class TaskDataVO {

    private String constructionPointname;

    private String taskName;

    private Integer status;

    private HashMap<String, String> dataMap;

    /**
     * 水平差值
     */
    @TableField("horizontalDifference")
    @ApiModelProperty(value = "水平差值")
    private float horizontalDifference;

    /**
     * 垂直差值
     */
    @TableField("verticalDifference")
    @ApiModelProperty(value = "垂直差值")
    private float verticalDifference;

    /**
     * 密实度
     */
    @ApiModelProperty(value = "密实度")
    private float compactness;

    @ApiModelProperty(value = "施工员名称")
    private String constructorName;

    @ApiModelProperty(value = "质检员名称")
    private String qualityInspectorName;

    @ApiModelProperty(value = "监理员名称")
    private String supervisorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "任务开始时间")
    private Date startTime;

    public String getConstructionPointname() {
        return constructionPointname;
    }

    public void setConstructionPointname(String constructionPointname) {
        this.constructionPointname = constructionPointname;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public float getHorizontalDifference() {
        return horizontalDifference;
    }

    public void setHorizontalDifference(float horizontalDifference) {
        this.horizontalDifference = horizontalDifference;
    }

    public float getVerticalDifference() {
        return verticalDifference;
    }

    public void setVerticalDifference(float verticalDifference) {
        this.verticalDifference = verticalDifference;
    }

    public float getCompactness() {
        return compactness;
    }

    public void setCompactness(float compactness) {
        this.compactness = compactness;
    }

    public HashMap<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public String getQualityInspectorName() {
        return qualityInspectorName;
    }

    public void setQualityInspectorName(String qualityInspectorName) {
        this.qualityInspectorName = qualityInspectorName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
