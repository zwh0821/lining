package com.isuperone.lining.common.enumration;

/**
 * @program: Lining
 * @description: 公司类别枚举
 * @author: Joe
 * @create: 2020-06-10 14:50
 **/
public enum EnterpriseCategoryEnum {

    owner(0, "业主"),
    supervisor(1, "监理"),
    construction(2, "施工");

    private int code;
    private String message;

    EnterpriseCategoryEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    EnterpriseCategoryEnum(int code, String message) {
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
        EnterpriseCategoryEnum[] enterpriseCategoryEnums = values();
        for (EnterpriseCategoryEnum enterpriseCategoryEnum : enterpriseCategoryEnums) {
            if (enterpriseCategoryEnum.getCode() == code) {
                return enterpriseCategoryEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        EnterpriseCategoryEnum[] enterpriseCategoryEnums = values();
        for (EnterpriseCategoryEnum enterpriseCategoryEnum : enterpriseCategoryEnums) {
            if (enterpriseCategoryEnum.getMessage().equals(value)) {
                return enterpriseCategoryEnum.getCode();
            }
        }
        return null;
    }


    public static EnterpriseCategoryEnum getByCode(Integer Code){
        for(EnterpriseCategoryEnum enterpriseCategoryEnum : values()){
            if (enterpriseCategoryEnum.getCode() == Code) {
                return enterpriseCategoryEnum;
            }
        }
        return null;
    }
}
