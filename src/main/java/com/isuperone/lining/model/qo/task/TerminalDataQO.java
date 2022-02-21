package com.isuperone.lining.model.qo.task;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @program: Lining
 * @description: 显传终端数据QO
 * @author: Joe
 * @create: 2020-05-21 14:55
 **/
public class TerminalDataQO {

    private Long deviceId;

    private Long taskId;

    private String L1;

    private String L2;

    private String L3;

    private String L4;

    private String L5;

    private String R1;

    private String R2;

    private String R3;

    private String R4;

    private String R5;

    private String Z0;

    private String Z1;

    private String Z2;

    private String Z3;

    private String Z4;

    @ApiModelProperty(value = "调用类型，0本地，1远程")
    private Integer type;

    private boolean status;

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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

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

    public String getL1() {
        return L1;
    }

    public void setL1(String l1) {
        L1 = l1;
    }

    public String getL2() {
        return L2;
    }

    public void setL2(String l2) {
        L2 = l2;
    }

    public String getL3() {
        return L3;
    }

    public void setL3(String l3) {
        L3 = l3;
    }

    public String getL4() {
        return L4;
    }

    public void setL4(String l4) {
        L4 = l4;
    }

    public String getL5() {
        return L5;
    }

    public void setL5(String l5) {
        L5 = l5;
    }

    public String getR1() {
        return R1;
    }

    public void setR1(String r1) {
        R1 = r1;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String r2) {
        R2 = r2;
    }

    public String getR3() {
        return R3;
    }

    public void setR3(String r3) {
        R3 = r3;
    }

    public String getR4() {
        return R4;
    }

    public void setR4(String r4) {
        R4 = r4;
    }

    public String getR5() {
        return R5;
    }

    public void setR5(String r5) {
        R5 = r5;
    }

    public String getZ1() {
        return Z1;
    }

    public void setZ1(String z1) {
        Z1 = z1;
    }

    public String getZ2() {
        return Z2;
    }

    public void setZ2(String z2) {
        Z2 = z2;
    }

    public String getZ3() {
        return Z3;
    }

    public void setZ3(String z3) {
        Z3 = z3;
    }

    public String getZ4() {
        return Z4;
    }

    public void setZ4(String z4) {
        Z4 = z4;
    }

    public String getZ0() {
        return Z0;
    }

    public void setZ0(String z0) {
        Z0 = z0;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
