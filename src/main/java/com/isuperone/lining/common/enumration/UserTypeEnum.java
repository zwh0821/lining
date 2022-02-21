package com.isuperone.lining.common.enumration;

/**
 * @program: Lining
 * @description: 用户类型枚举
 * @author: Joe
 * @create: 2020-06-10 11:59
 **/
public enum UserTypeEnum {

    admin(1,"admin"),
    ordinary(0,"ordinary");


    private int code;
    private String message;

    UserTypeEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    UserTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
