package com.isuperone.lining.model.vo.sys;

import com.isuperone.lining.model.entity.sys.SysOperationLog;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: Lining
 * @description: 操作日志View Object
 * @author: Joe
 * @create: 2020-06-01 18:31
 **/
public class SysOperationLogVO extends SysOperationLog {

    @ApiModelProperty(value = "操作者")
    public String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
