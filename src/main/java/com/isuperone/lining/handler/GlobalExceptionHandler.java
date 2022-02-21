package com.isuperone.lining.handler;

import cn.hutool.core.lang.Console;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: Lining
 * @description: 全局异常
 * @author: Joe
 * @create: 2020-06-01 15:07
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ReturnResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Console.log(e.getMessage(), e);
        return ReturnResultUtils.returnFail(0,e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
