package com.isuperone.lining.model.dto.task;

import java.util.List;

/**
 * @program: Lining
 * @description: 备注历史
 * @author: Joe
 * @create: 2020-06-05 10:56
 **/
public class TaskRemarkDto {

    public List<RemarkDto> constructionRemark;

    public List<RemarkDto> qualityInspectorRemark;

    public List<RemarkDto> supervisorRemark;

    public List<RemarkDto> rejectRemark;

    public List<RemarkDto> getConstructionRemark() {
        return constructionRemark;
    }

    public void setConstructionRemark(List<RemarkDto> constructionRemark) {
        this.constructionRemark = constructionRemark;
    }

    public List<RemarkDto> getQualityInspectorRemark() {
        return qualityInspectorRemark;
    }

    public void setQualityInspectorRemark(List<RemarkDto> qualityInspectorRemark) {
        this.qualityInspectorRemark = qualityInspectorRemark;
    }

    public List<RemarkDto> getSupervisorRemark() {
        return supervisorRemark;
    }

    public void setSupervisorRemark(List<RemarkDto> supervisorRemark) {
        this.supervisorRemark = supervisorRemark;
    }

    public List<RemarkDto> getRejectRemark() {
        return rejectRemark;
    }

    public void setRejectRemark(List<RemarkDto> rejectRemark) {
        this.rejectRemark = rejectRemark;
    }
}
