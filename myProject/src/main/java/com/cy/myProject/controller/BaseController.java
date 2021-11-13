package com.cy.myProject.controller;


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
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The user name already exists");
        } else if(e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("User dose not exist");
        }else if(e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("Password is wrong");
        }
        else if(e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("oops! An unknown error");
        }
        else if(e instanceof updateException) {
            result.setState(5004);
            result.setMessage("Update Data Exception");
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
