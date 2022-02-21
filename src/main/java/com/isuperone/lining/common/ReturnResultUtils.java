package com.isuperone.lining.common;

/**
 * @program: Lining
 * @description: 返回工具类
 * @author: Joe
 * @create: 2020-04-17 11:27
 **/

import com.isuperone.lining.common.enumration.ReturnResultContant;

/**
 * **********************************************************
 *
 * @Project:   和前端接口交互的统一格式Result类的工具类
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-09-28 22:03
 * @description:
 ************************************************************/
public class ReturnResultUtils{

    /***
     * 成功 不带数据
     * @return  返回状态码与状态信息
     */
    public static ReturnResult returnSuccess(){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(ReturnResultContant.SUCCESS);
        returnResult.setMessage("success");
        return returnResult;
    }
    /***
     * 成功 带数据
     * @return  返回状态码,状态信息与数据
     */
    public static ReturnResult returnSuccess(Object data){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(ReturnResultContant.SUCCESS);
        returnResult.setMessage("success");
        returnResult.setResult(data);
        return returnResult;
    }

    /***
     * 成功 带数据
     * @return  返回状态码,状态信息与数据
     */
    public static ReturnResult returnSuccess(Object data,String message){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(ReturnResultContant.SUCCESS);
        returnResult.setMessage(message);
        returnResult.setResult(data);
        return returnResult;
    }

    /***
     * 失败
     * @return  返回状态码与状态信息
     */
    public static ReturnResult returnFail(Integer code, String message){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }
}
