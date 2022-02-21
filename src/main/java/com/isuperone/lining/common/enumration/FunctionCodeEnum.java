package com.isuperone.lining.common.enumration;

public enum FunctionCodeEnum {

    zero(0, "0000"),
    one(1, "0001"),
    two(2, "0010"),
    three(3, "0011"),
    four(4, "0100"),
    five(5, "0101"),
    six(6, "0110"),
    seven(7, "0111"),
    eight(8, "1000"),
    night(9, "1001"),
    ten(10, "1010"),
    a(11, "1011"),
    b(12, "1100"),
    c(13, "1101"),
    d(14, "1110"),
    e(15, "1111");


    private int code;
    private String message;

    FunctionCodeEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    FunctionCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getEnumByCode(Integer code) {
        if (code != null) {
            for (FunctionCodeEnum functionCodeEnum : FunctionCodeEnum.values()) {
                if (functionCodeEnum.getCode() == code) {
                    return functionCodeEnum.getMessage();
                }
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
