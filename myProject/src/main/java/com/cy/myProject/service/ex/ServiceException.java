package com.cy.myProject.service.ex;

//业务层异常基类  运行的过程中的产生，其他时候不产生， 所以较运行时异常
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }
//  经常用
    public ServiceException(String message) {
        super(message);
    }
    //  经常用
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
