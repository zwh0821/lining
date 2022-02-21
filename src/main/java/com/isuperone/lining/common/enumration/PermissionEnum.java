package com.isuperone.lining.common.enumration;

/**
 * @program: Lining
 * @description: 操作权限枚举
 * @author: Joe
 * @create: 2020-05-13 11:27
 **/
public enum PermissionEnum {

    add("add", "新增"),
    get("get", "查询"),
    update("update", "修改"),
    query("query", "列表"),
    delete("delete", "删除"),
    imports("import", "导入"),
    exports("export", "导出");


    private String code;
    private String message;

    PermissionEnum() {
        this.code = this.name();
        this.message = this.name();
    }

    PermissionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static boolean contain(String type) {
        if (null == type) {
            return false;
        }
        for (PermissionEnum permissionEnum : values()) {
            if (type == permissionEnum.getCode()) {
                return true;
            }
        }
        return false;
    }

    public static PermissionEnum getEnumByType(String code) {
        if (code != null) {
            for (PermissionEnum permissionEnum : PermissionEnum.values()) {
                if (permissionEnum.getCode().equals(code)) {
                    return permissionEnum;
                }
            }
        }
        return null;
    }

    public static String getValue(String code) {
        PermissionEnum[] permissionEnums = values();
        for (PermissionEnum permissionEnum : permissionEnums) {
            if (permissionEnum.getCode().equals(code)) {
                return permissionEnum.getMessage();
            }
        }
        return null;
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
}
