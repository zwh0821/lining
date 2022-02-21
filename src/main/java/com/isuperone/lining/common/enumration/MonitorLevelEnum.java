package com.isuperone.lining.common.enumration;

public enum MonitorLevelEnum {
    DYJH(0, "单一简化"),
    DYBZ(1, "单一标准"),
    DYJX(2, "单一精细"),
    ZHJH(3, "综合简化"),
    ZHJB(4,"综合基本"),
    ZHBJ(5,"综合标准"),
    ZHJX(6,"综合惊喜");

    private int code;
    private String message;

    MonitorLevelEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    MonitorLevelEnum(int code, String message) {
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
        MonitorLevelEnum[] monitorLevelEnums = values();
        for (MonitorLevelEnum monitorLevelEnum : monitorLevelEnums) {
            if (monitorLevelEnum.getCode() == code) {
                return monitorLevelEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        MonitorLevelEnum[] monitorLevelEnums = values();
        for (MonitorLevelEnum monitorLevelEnum : monitorLevelEnums) {
            if (monitorLevelEnum.getMessage().equals(value)) {
                return monitorLevelEnum.getCode();
            }
        }
        return null;
    }


    public static MonitorLevelEnum getByValue(Integer value){
        for(MonitorLevelEnum monitorLevelEnum : values()){
            if (monitorLevelEnum.getCode() == value) {
                return monitorLevelEnum;
            }
        }
        return null;
    }
}
