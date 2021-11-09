package com.cy.myProject.controller;


import com.cy.myProject.service.ex.ServiceException;
import com.cy.myProject.service.ex.UsernameDuplicatedException;
import com.cy.myProject.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

//表示控制层类的基类
public class BaseController {
    //操作成功的状态码
    public static final int ok=200;
    // 请求处理方法： 这个方法的返回值就是需要传递到前端的数据
    // 凡是ServiceException.class抛出的异常都会被拦截到@ExceptionHandler
    @ExceptionHandler(ServiceException.class)//用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("The user name already exists");
        } else {
            result.setState(5000);
            result.setMessage("oops! An unknown error");
        }
        return result;
    }

}
