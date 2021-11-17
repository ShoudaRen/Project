package com.cy.myProject.service.ex;

public class InsertCountLimitedException extends ServiceException{

    public InsertCountLimitedException() {
        super();
    }

    public InsertCountLimitedException(String message) {
        super(message);
    }

    public InsertCountLimitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertCountLimitedException(Throwable cause) {
        super(cause);
    }

    protected InsertCountLimitedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
