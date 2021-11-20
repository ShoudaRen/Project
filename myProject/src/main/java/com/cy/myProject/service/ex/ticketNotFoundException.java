package com.cy.myProject.service.ex;

public class ticketNotFoundException extends ServiceException{

    public ticketNotFoundException() {
        super();
    }

    public ticketNotFoundException(String message) {
        super(message);
    }

    public ticketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ticketNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ticketNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
