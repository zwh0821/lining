package com.isuperone.lining.common.exception;

/**
 * @program: Lining
 * @description: 异常Exception
 * @author: Joe
 * @create: 2020-04-28 12:21
 * Service层公用的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
