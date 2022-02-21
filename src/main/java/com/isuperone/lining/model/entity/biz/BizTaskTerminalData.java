package com.isuperone.lining.model.entity.biz;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class BizTaskTerminalData implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 设备Id
     */
    @TableField("deviceId")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "设备Id")
    private Long deviceId;

    @TableField("taskId")
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "设备Id")
    private Long taskId;

    /**
     * 显传终端Id
     */
    @TableField("terminalId")
    private String terminalId;

    /**
     * json数据
     */
    @TableField("terminalData")
    private String terminalData;

    @TableField("createTime")
    private Date createTime;

    @TableField("status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    public String getTerminalData() {
        return terminalData;
    }

    public void setTerminalData(String terminalData) {
        this.terminalData = terminalData;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BizTaskTerminalData{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", taskId=" + taskId +
                ", terminalId='" + terminalId + '\'' +
                ", terminalData='" + terminalData + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
