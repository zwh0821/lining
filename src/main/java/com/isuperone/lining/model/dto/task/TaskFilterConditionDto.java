package com.isuperone.lining.model.dto.task;

/**
 * @program: Lining
 * @description: 统计数据条件参数
 * @author: Joe
 * @create: 2020-06-17 11:48
 **/
public class TaskFilterConditionDto {

    //业主单位
    private Long projectEnterpriseId;

    //监理单位
    private Long supervisionEnterpriseId;

    //施工单位
    private Long constructionEnterpriseId;

    //施工员
    private Long constructorId;

    //监理员
    private Long supervisor;

    //质检员
    private Long qualityInspector;

    public Long getProjectEnterpriseId() {
        return projectEnterpriseId;
    }

    public void setProjectEnterpriseId(Long projectEnterpriseId) {
        this.projectEnterpriseId = projectEnterpriseId;
    }

    public Long getSupervisionEnterpriseId() {
        return supervisionEnterpriseId;
    }

    public void setSupervisionEnterpriseId(Long supervisionEnterpriseId) {
        this.supervisionEnterpriseId = supervisionEnterpriseId;
    }

    public Long getConstructionEnterpriseId() {
        return constructionEnterpriseId;
    }

    public void setConstructionEnterpriseId(Long constructionEnterpriseId) {
        this.constructionEnterpriseId = constructionEnterpriseId;
    }

    public Long getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(Long constructorId) {
        this.constructorId = constructorId;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }

    public Long getQualityInspector() {
        return qualityInspector;
    }

    public void setQualityInspector(Long qualityInspector) {
        this.qualityInspector = qualityInspector;
    }
}
