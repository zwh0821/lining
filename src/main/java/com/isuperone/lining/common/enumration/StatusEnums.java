package com.isuperone.lining.common.enumration;


public enum StatusEnums {

    systemStatus_enable(1,"正常"),
    systemStatus_disable(0,"禁用"),
    systemStatus_deleted(-1,"删除");


    private int code;
    private String message;

    StatusEnums() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    StatusEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getValue(Integer code) {
        StatusEnums[] statusEnums = values();
        for (StatusEnums statusEnum : statusEnums) {
            if (statusEnum.getCode() == code) {
                return statusEnum.getMessage();
            }
        }
        return null;
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
