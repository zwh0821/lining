package com.isuperone.lining.common.enumration;

/**
 * 工单状态
 */
public enum OperationEnum {

    insertOrder("saveOrder", "创建工单"),
    removeOrder("removeOrder","删除工单"),
    acceptOrder("acceptOrder","接收工单"),
    handleOrder("handleOrder","处理工单"),
    finishOrder("finishOrder","关闭工单"),
    rejectOrder("rejectOrder","驳回工单");


    private String code;
    private String message;

    OperationEnum() {
        this.code = this.name();
        this.message = this.name();
    }

    OperationEnum(String code, String message) {
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

}
