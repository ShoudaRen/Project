package com.cy.myProject.controller;


import com.cy.myProject.controller.ex.*;
import com.cy.myProject.service.ex.*;
import com.cy.myProject.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.sql.BatchUpdateException;

// Represents the base class of the control layer class
public class BaseController {
    // Indicates the status code of the successful operation
    public static final int ok=200;
    // Request handling method: The return value of this method is the data that needs to be passed to the front end
    // Any exception thrown by ServiceException.class is intercepted to @ExceptionHandler
    //The business layer throws exceptions for the control layer. The control layer does not throw exceptions, but sends error information to the front end for business judgment
    @ExceptionHandler({ServiceException.class,FileUploadException.class})// It is used to uniformly handle thrown exceptions
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The user name already exists");
        } else if(e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("User dose not exist");
        }else if(e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("Password is wrong");
        }
        else if(e instanceof InsertCountLimitedException) {
            result.setState(4003);
            result.setMessage("passengers out of limitation");
        }
        else if(e instanceof PassengerNotFoundException) {
            result.setState(4004);
            result.setMessage("passengers does not find");
        }
        else if(e instanceof AccessDeniedException) {
            result.setState(4006);
            result.setMessage("illegal Access");
        }
        else if(e instanceof BookingNotFoundException) {
            result.setState(4007);
            result.setMessage("no booking exist");
        }
        else if(e instanceof ticketNotFoundException) {
            result.setState(4007);
            result.setMessage("tickets sold out!");
        }
        else if(e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("oops! insert exception");
        }
        else if(e instanceof DeleteException) {
            result.setState(5002);
            result.setMessage("oops!delete exception");
        }
        else if(e instanceof updateException) {
            result.setState(5004);
            result.setMessage("Update Data Exception");
        }
        else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    /**
     * get session uid
     * @param session session object
     * @return the user's uid
     */
    public final Integer getUidFromSession(HttpSession session){
          return  Integer.valueOf(session.getAttribute("uid").toString());
    }
    /**
     * get user's name
     * @param session  object
     * @return  return name
     * session return object
     */
      protected final String getUsernameFromSession(HttpSession session){
         return session.getAttribute("username").toString();
      }


}
