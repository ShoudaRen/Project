package com.cy.myProject.controller;

import com.cy.myProject.entity.User;
import com.cy.myProject.service.IUserService;
import com.cy.myProject.service.ex.InsertException;
import com.cy.myProject.service.ex.UsernameDuplicatedException;
import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //@RestController是==@@Controller+ @ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")//    这个方法可以接收什么样的请求？ users（上面那个引号） 下的reg请求可以被拦截
    //example:http://localhost:8080/users/reg?username=Tom123&password=123456
//    @ResponseBody //表示此方法的响应结果以Json格式进行数据的响应给到前端

    //接收前端的数据
    //Void 无数据类型   //后端接受前端请求的方法
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(ok);

    }










//    public JsonResult<Void> reg(User user) {
//        //创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//
//        try {
//            //调用业务层的方法
//            userService.reg(user);//调用的使UserServiceIml的方法
//            result.setState(2000);
//            //前端窗口报错
//            result.setMessage("Register Succeed");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            //前端窗口报错
//            result.setMessage("The user name already exists");
//        } catch (InsertException e) {
//            //前端窗口报错
//            result.setState(5000);
//            result.setMessage("oops! An unknown error");
//        }
//        return result;
//
//    }


}