package com.isuperone.lining.model.qo.task;

import com.isuperone.lining.model.dto.task.TaskAttachmentDto;
import com.isuperone.lining.model.entity.biz.BizTask;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-05-29 09:56
 **/
public class BizTaskQO extends BizTask {

    private TaskAttachmentDto attachment;

    //备注
    private String memo;

    public TaskAttachmentDto getAttachment() {
        return attachment;
    }

    public void setAttachment(TaskAttachmentDto attachment) {
        this.attachment = attachment;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
