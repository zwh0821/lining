package com.isuperone.lining.model.requestParam.biz.bizTaskTerminalData;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-12-04 15:49
 **/
public class ImportTerminalDataToThirdPartParam {

    private List<Long> taskIds;

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }
}
