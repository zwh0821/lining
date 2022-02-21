package com.isuperone.lining.model.entity.biz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
public class BizProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value = "主键ID")
    private Long id;


    /**
     * 项目名称
     */
    @TableField("projectName")
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目地址
     */
    @ApiModelProperty(value = "项目地址")
    private String address;

    /**
     * 建设单位
     */
    @TableField("enterpriseId")
    @ApiModelProperty(value = "建设单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long enterpriseId;

    /**
     * 建设单位联系人
     */
    @TableField("projectContractor")
    @ApiModelProperty(value = "建设单位联系人")
    private String projectContractor;

    /**
     * 建设单位联系电话
     */
    @ApiModelProperty(value = "建设单位联系电话")
    private String phone;

    /**
     * 开工日期
     */
    @TableField("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "开工日期")
    private Date startDate;

    /**
     * 竣工日期
     */
    @TableField("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "竣工日期")
    private Date endDate;

    /**
     * 建设时间
     */
    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "建设时间")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getProjectContractor() {
        return projectContractor;
    }

    public void setProjectContractor(String projectContractor) {
        this.projectContractor = projectContractor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BizProject{" +
                "projectName=" + projectName +
                ", address=" + address +
                ", enterpriseId=" + enterpriseId +
                ", projectContractor=" + projectContractor +
                ", phone=" + phone +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createTime=" + createTime +
                "}";
    }
}
