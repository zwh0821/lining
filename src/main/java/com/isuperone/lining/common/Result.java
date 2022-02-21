package com.isuperone.lining.common;

/**
 * @program: Lining
 * @description: 响应
 * @author: Joe
 * @create: 2020-03-27 17:21
 **/
public class Result {

    public String message;
    public Object data;
    public int resultCode; ;

    public Result(){}

    public Result(int resultCode, String message,Object data) {
        this.message = message;
        this.data = data;
        this.resultCode = resultCode;
    }

    public  void  LogSuc(Object data){
        this.data = data;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
