package com.cy.myProject.controller;


import com.cy.myProject.controller.ex.*;
import com.cy.myProject.service.ex.*;
import com.cy.myProject.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.sql.BatchUpdateException;

//表示控制层类的基类
public class BaseController {
    //操作成功的状态码
    public static final int ok=200;
    // 请求处理方法： 这个方法的返回值就是需要传递到前端的数据
    // 凡是ServiceException.class抛出的异常都会被拦截到@ExceptionHandler
    //业务层抛异常是给控制层用的，控制层不是在抛异常，而是吧错误信息相应给前端，好去做业务的判断
    @ExceptionHandler({ServiceException.class,FileUploadException.class})//用于统一处理抛出的异常
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
//   从哪个session获取UID
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


      //reference 查看订单
}
