package com.isuperone.lining.common.enumration;

/**
 * @program: Lining
 * @description: 方法调用类型
 * @author: Joe
 * @create: 2020-08-01 17:04
 **/
public enum MethodCallTypeEnum {

    local(0, "本地"),
    remote(1, "远程");


    private Integer code;
    private String message;

    MethodCallTypeEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    MethodCallTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getValue(Integer code) {
        MethodCallTypeEnum[] methodCallTypeEnums = values();
        for (MethodCallTypeEnum methodCallTypeEnum : methodCallTypeEnums) {
            if (methodCallTypeEnum.getCode().equals(code)) {
                return methodCallTypeEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        MethodCallTypeEnum[] methodCallTypeEnums = values();
        for (MethodCallTypeEnum methodCallTypeEnum : methodCallTypeEnums) {
            if (methodCallTypeEnum.getMessage().equals(value)) {
                return methodCallTypeEnum.getCode();
            }
        }
        return null;
    }

}
