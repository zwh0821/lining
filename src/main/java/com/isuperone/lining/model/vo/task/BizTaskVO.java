package com.isuperone.lining.model.vo.task;

import com.isuperone.lining.model.dto.task.TaskAttachmentDto;
import com.isuperone.lining.model.dto.task.TaskRemarkDto;
import com.isuperone.lining.model.entity.biz.BizTask;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: Lining
 * @description: bizTask View Object
 * @author: Joe
 * @create: 2020-05-18 11:20
 **/
public class BizTaskVO extends BizTask {

    @ApiModelProperty(value = "工点名称")
    private String constructionPointName;

    @ApiModelProperty(value = "施工标名称")
    private String constructionSectionName;

    @ApiModelProperty(value = "监理标名称")
    private String supervisionSectionName;

    @ApiModelProperty(value = "施工员名称")
    private String constructorName;

    @ApiModelProperty(value = "监理员名称")
    private String supervisorName;

    @ApiModelProperty(value = "质检员名称")
    private String qualityInspectorName;

    @ApiModelProperty(value = "业主单位")
    private String ownerEnterpriseName;

    @ApiModelProperty(value = "施工标单位")
    private String constructionSectionEnterpriseName;

    @ApiModelProperty(value = "监理标单位")
    private String supervisionSectionEnterpriseName;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "附件")
    private TaskAttachmentDto attachment;

    @ApiModelProperty(value = "任务备注")
    private TaskRemarkDto taskRemark;

    public String getConstructionPointName() {
        return constructionPointName;
    }

    public void setConstructionPointName(String constructionPointName) {
        this.constructionPointName = constructionPointName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConstructionSectionName() {
        return constructionSectionName;
    }

    public void setConstructionSectionName(String constructionSectionName) {
        this.constructionSectionName = constructionSectionName;
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

    public String getSupervisionSectionName() {
        return supervisionSectionName;
    }

    public void setSupervisionSectionName(String supervisionSectionName) {
        this.supervisionSectionName = supervisionSectionName;
    }

    public TaskAttachmentDto getAttachment() {
        return attachment;
    }

    public void setAttachment(TaskAttachmentDto attachment) {
        this.attachment = attachment;
    }

    public TaskRemarkDto getTaskRemark() {
        return taskRemark;
    }

    public void setTaskRemark(TaskRemarkDto taskRemark) {
        this.taskRemark = taskRemark;
    }

    public String getConstructionSectionEnterpriseName() {
        return constructionSectionEnterpriseName;
    }

    public void setConstructionSectionEnterpriseName(String constructionSectionEnterpriseName) {
        this.constructionSectionEnterpriseName = constructionSectionEnterpriseName;
    }

    public String getSupervisionSectionEnterpriseName() {
        return supervisionSectionEnterpriseName;
    }

    public void setSupervisionSectionEnterpriseName(String supervisionSectionEnterpriseName) {
        this.supervisionSectionEnterpriseName = supervisionSectionEnterpriseName;
    }

    public String getOwnerEnterpriseName() {
        return ownerEnterpriseName;
    }

    public void setOwnerEnterpriseName(String ownerEnterpriseName) {
        this.ownerEnterpriseName = ownerEnterpriseName;
    }

}

