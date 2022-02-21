package com.isuperone.lining.common.enumration;

public enum FaultOrderStatusEnum {

    waiting(0, "待处理"),
    handling(1, "处理中"),
    success(2, "已处理"),
    close(3, "已关闭");


    private int code;
    private String message;

    FaultOrderStatusEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    FaultOrderStatusEnum(int code, String message) {
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

    public static String getValue(Integer code) {
        FaultOrderStatusEnum[] faultOrderStatusEnums = values();
        for (FaultOrderStatusEnum faultOrderStatusEnum : faultOrderStatusEnums) {
            if (faultOrderStatusEnum.getCode() == code) {
                return faultOrderStatusEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        FaultOrderStatusEnum[] faultOrderStatusEnums = values();
        for (FaultOrderStatusEnum faultOrderStatusEnum : faultOrderStatusEnums) {
            if (faultOrderStatusEnum.getMessage().equals(value)) {
                return faultOrderStatusEnum.getCode();
            }
        }
        return null;
    }

}
