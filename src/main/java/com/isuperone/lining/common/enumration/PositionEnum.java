package com.isuperone.lining.common.enumration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Lining
 * @description: 操作权限枚举
 * @author: Joe
 * @create: 2020-05-13 11:27
 **/
public enum PositionEnum {

    Constructor("1","施工员"),
    Inspector("2","质检员"),
    Supervisor("3","监理员"),
    Manager("4","项目管理员");


    private String code;
    private String message;

    PositionEnum() {
        this.code = this.name();
        this.message = this.name();
    }

    PositionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static boolean contain(Integer code) {
        if (null == code) {
            return false;
        }
        for (PositionEnum positionEnum : values()) {
            if (code.equals(positionEnum.getCode())) {
                return true;
            }
        }
        return false;
    }

    public static PositionEnum getEnumByCode(String code) {
        if (code != null) {
            for (PositionEnum positionEnum : PositionEnum.values()) {
                if (positionEnum.getCode().equals(code)) {
                    return positionEnum;
                }
            }
        }
        return null;
    }

    public static String getValue(String code) {
        PositionEnum[] positionEnums = values();
        for (PositionEnum positionEnum : positionEnums) {
            if (positionEnum.getCode().equals(code)) {
                return positionEnum.getMessage();
            }
        }
        return null;
    }
}
