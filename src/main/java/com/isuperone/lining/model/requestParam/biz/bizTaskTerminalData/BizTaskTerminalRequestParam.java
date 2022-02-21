package com.isuperone.lining.model.requestParam.biz.bizTaskTerminalData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.entity.biz.BizTaskTerminalImportRecord;

import java.util.Date;

/**
 * @program: Lining
 * @description: 终端上传数据请求参数
 * @author: Joe
 * @create: 2020-11-07 10:12
 **/
public class BizTaskTerminalRequestParam   {

    private String taskId;

    private Page<BizTaskTerminalImportRecord> page;

    private Date startTime;

    private Date endTime;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Page<BizTaskTerminalImportRecord> getPage() {
        if(page == null){
            return new Page<BizTaskTerminalImportRecord>();
        }
        return page;
    }

    public void setPage(Page<BizTaskTerminalImportRecord> page) {
        this.page = page;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
