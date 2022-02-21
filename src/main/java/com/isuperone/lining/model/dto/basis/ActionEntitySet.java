package com.isuperone.lining.model.dto.basis;

/**
 * @program: Lining
 * @description: 操作权限信息
 * @author: Joe
 * @create: 2020-04-22 16:00
 **/
public class ActionEntitySet {

    public String action;

    public String describe;

    public boolean defaultCheck;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isDefaultCheck() {
        return defaultCheck;
    }

    public void setDefaultCheck(boolean defaultCheck) {
        this.defaultCheck = defaultCheck;
    }
}
