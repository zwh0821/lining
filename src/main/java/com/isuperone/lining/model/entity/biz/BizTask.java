package com.isuperone.lining.model.entity.biz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.isuperone.lining.common.enumration.MonitorLevelEnum;
import com.isuperone.lining.common.enumration.TaskStatusEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public class BizTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 工点
     */
    @TableField("constructionPoint")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "工点")
    private Long constructionPoint;

    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称")
    private String name;

    /**
     * 施工长度
     */
    @TableField("constructionLength")
    @ApiModelProperty(value = "施工长度")
    private Float constructionLength;

    /**
     * 监测等级
     */
    @ApiModelProperty(value = "监测等级")
    private Integer level;

    /**
     * 监测等级
     */
    @ApiModelProperty(value = "监测等级名称")
    @TableField(exist = false)
    private String levelName;


    /**
     * 施工员
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "施工员")
    private Long constructorId;

    /**
     * 质检员
     */
    @TableField("qualityInspector")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "质检员")
    private Long qualityInspector;

    /**
     * 监理员
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "监理员")
    private Long supervisor;

    /**
     * 当前状态
     */
    @ApiModelProperty(value = "当前状态")
    private Integer status;

    /**
     * 状态名称
     */
    @TableField(exist = false)
    private String statusName;

    /**
     * 创建时间
     */
    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

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
    @TableField("compactness")
    @ApiModelProperty(value = "密实度")
    private float compactness;

    /**
     * 任务开始时间
     */
    @TableField("startTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "任务开始时间")
    private Date startTime;

    /**
     * 自检完成时间
     */
    @TableField("submitTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "自检完成时间")
    private Date submitTime;

    /**
     * 审核完成时间
     */
    @TableField("auditTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "审核完成时间")
    private Date auditTime;

    /**
     * 质检完成时间
     */
    @TableField("approvalTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "质检完成时间")
    private Date approvalTime;

    /**
     * 任务结束时间
     */
    @TableField("finishTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value = "任务结束时间")
    private Date finishTime;

    /**
     * 项目
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "项目")
    @TableField("projectId")
    private Long projectId;

    /**
     * 监理标段
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "监理标段")
    @TableField("supervisorSection")
    private Long supervisorSection;

    /**
     * 施工标段
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "施工标段")
    @TableField("constructionSection")
    private Long constructionSection;

    /**
     * 业主单位
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "业主单位")
    @TableField("ownerEnterprise")
    private Long ownerEnterprise;

    /**
     * 监理单位
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "监理单位")
    @TableField("supervisorEnterprise")
    private Long supervisorEnterprise;

    /**
     * 施工单位
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "施工单位")
    @TableField("constructionEnterprise")
    private Long constructionEnterprise;

    /**
     * 默认工控机
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "默认工控机")
    @TableField("defaultDevice")
    private Long defaultDevice;

    /**
     * 二维码地址
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "二维码地址")
    @TableField("qrCodePath")
    private String qrCodePath;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConstructionPoint() {
        return constructionPoint;
    }

    public void setConstructionPoint(Long constructionPoint) {
        this.constructionPoint = constructionPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getConstructionLength() {
        return constructionLength;
    }

    public void setConstructionLength(Float constructionLength) {
        this.constructionLength = constructionLength;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(Long constructor) {
        this.constructorId = constructor;
    }

    public Long getQualityInspector() {
        return qualityInspector;
    }

    public void setQualityInspector(Long qualityInspector) {
        this.qualityInspector = qualityInspector;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getStatusName() {
        return TaskStatusEnum.getValue(this.status);
    }

    public void setStatusName(String statusName) {
        this.statusName = TaskStatusEnum.getValue(this.status);
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getSupervisorSection() {
        return supervisorSection;
    }

    public void setSupervisorSection(Long supervisorSection) {
        this.supervisorSection = supervisorSection;
    }

    public Long getConstructionSection() {
        return constructionSection;
    }

    public void setConstructionSection(Long constructionSection) {
        this.constructionSection = constructionSection;
    }

    public Long getOwnerEnterprise() {
        return ownerEnterprise;
    }

    public void setOwnerEnterprise(Long ownerEnterprise) {
        this.ownerEnterprise = ownerEnterprise;
    }

    public Long getSupervisorEnterprise() {
        return supervisorEnterprise;
    }

    public void setSupervisorEnterprise(Long supervisorEnterprise) {
        this.supervisorEnterprise = supervisorEnterprise;
    }

    public Long getConstructionEnterprise() {
        return constructionEnterprise;
    }

    public void setConstructionEnterprise(Long constructionEnterprise) {
        this.constructionEnterprise = constructionEnterprise;
    }

    public String getLevelName() {
        return MonitorLevelEnum.getValue(level);
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getDefaultDevice() {
        return defaultDevice;
    }

    public void setDefaultDevice(Long defaultDevice) {
        this.defaultDevice = defaultDevice;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }

    @Override
    public String toString() {
        return "BizTask{" +
                "id=" + id +
                ", constructionPoint=" + constructionPoint +
                ", name='" + name + '\'' +
                ", constructionLength=" + constructionLength +
                ", level=" + level +
                ", constructorId=" + constructorId +
                ", qualityInspector=" + qualityInspector +
                ", supervisor=" + supervisor +
                ", status=" + status +
                ", statusName='" + statusName + '\'' +
                ", createTime=" + createTime +
                ", horizontalDifference=" + horizontalDifference +
                ", verticalDifference=" + verticalDifference +
                ", compactness=" + compactness +
                ", startTime=" + startTime +
                ", submitTime=" + submitTime +
                ", auditTime=" + auditTime +
                ", approvalTime=" + approvalTime +
                ", finishTime=" + finishTime +
                ", projectId=" + projectId +
                ", supervisorSection=" + supervisorSection +
                ", constructionSection=" + constructionSection +
                ", ownerEnterprise=" + ownerEnterprise +
                ", supervisorEnterprise=" + supervisorEnterprise +
                ", constructionEnterprise=" + constructionEnterprise +
                '}';
    }
}
