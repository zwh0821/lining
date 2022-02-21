package com.isuperone.lining.model.vo.sys;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-07-07 18:26
 **/
public class ActionVO {

    private String action;

    private Boolean defaultCheck;

    private String describe;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getDefaultCheck() {
        return defaultCheck;
    }

    public void setDefaultCheck(Boolean defaultCheck) {
        this.defaultCheck = defaultCheck;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
