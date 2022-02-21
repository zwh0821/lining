package com.isuperone.lining.common.enumration;

public  enum TaskStatusEnum {

    prepare(0, "已准备"),
    submit(1, "已自检"),
    audit(2, "已审核"),
    approval(3, "已审批"),
    start(4,"已开始"),
    finish(5,"已完成");


    private int code;
    private String message;

    TaskStatusEnum() {
        this.code = this.name().hashCode();
        this.message = this.name();
    }

    TaskStatusEnum(int code, String message) {
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
        TaskStatusEnum[] taskStatusEnums = values();
        for (TaskStatusEnum taskStatusEnum : taskStatusEnums) {
            if (taskStatusEnum.getCode() == code) {
                return taskStatusEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String value) {
        TaskStatusEnum[] taskStatusEnums = values();
        for (TaskStatusEnum taskStatusEnum : taskStatusEnums) {
            if (taskStatusEnum.getMessage().equals(value)) {
                return taskStatusEnum.getCode();
            }
        }
        return null;
    }


    public static TaskStatusEnum getByValue(Integer value){
        for(TaskStatusEnum taskStatusEnum : values()){
            if (taskStatusEnum.getCode() == value) {
                return taskStatusEnum;
            }
        }
        return null;
    }

}
