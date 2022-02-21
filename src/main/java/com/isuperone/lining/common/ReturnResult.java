package com.isuperone.lining.common;

import java.io.Serializable;


/**
 * **********************************************************
 *
 * @Project:   和前端接口交互的统一格式
 * @Author : joe
 * @description:
 ************************************************************/
public class ReturnResult<T> implements Serializable {

    //状态码
    private Integer code;
    //提示信息
    private String message;
    //返回数据
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}