package com.isuperone.lining.model.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-06-05 11:11
 **/
public class RemarkDto {

    public String remark;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date createTime;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
