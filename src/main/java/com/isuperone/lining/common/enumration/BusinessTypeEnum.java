package com.isuperone.lining.common.enumration;

public enum BusinessTypeEnum {


    faultOrder(0, "工单"),
    task(1, "任务");


    private int code;
    private String message;

    BusinessTypeEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    BusinessTypeEnum(int code, String message) {
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
        BusinessTypeEnum[] businessTypeEnums = values();
        for (BusinessTypeEnum businessTypeEnum : businessTypeEnums) {
            if (businessTypeEnum.getCode() == code) {
                return businessTypeEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        BusinessTypeEnum[] businessTypeEnums = values();
        for (BusinessTypeEnum businessTypeEnum : businessTypeEnums) {
            if (businessTypeEnum.getMessage().equals(value)) {
                return businessTypeEnum.getCode();
            }
        }
        return null;
    }

}
