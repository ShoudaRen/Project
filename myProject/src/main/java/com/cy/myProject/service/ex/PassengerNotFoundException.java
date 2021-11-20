package com.cy.myProject.service.ex;

// passenger does not exist
public class PassengerNotFoundException extends ServiceException {
    public PassengerNotFoundException() {
        super();
    }

    public PassengerNotFoundException(String message) {
        super(message);
    }

    public PassengerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassengerNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PassengerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
