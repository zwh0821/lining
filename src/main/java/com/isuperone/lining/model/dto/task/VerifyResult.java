package com.isuperone.lining.model.dto.task;

/**
 * @program: Lining
 * @description: 校验结果类
 * @author: Joe
 * @create: 2020-05-22 11:45
 **/
public class VerifyResult {

    public boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
