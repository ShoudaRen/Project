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
        return new JsonResult<Void>(ok);

    }
    @RequestMapping("login")//路径
    public JsonResult<User> login(String username,String password){

        User data=userService.login(username,password);
        //如果 userService.login(username,password);有异常会被
        // baseController里的@ExceptionHandler(ServiceException.class)捕获
        // 进而在handleException（）里进行处理， 没有异常直接返回JsonResult<User>(ok)给前端
        //        把data放进去传给前端
        return new JsonResult<User>(ok,data);// JsonResult<User>的构造器
           //下一步
           //        在前端进行测试u
      // example: http://localhost:8080/users/login?username=test4add&password=123
//        前端返回所有test4add的信息
        //{"state":200,"data":{"createdUser":"test4add",
        // "createdTime":"2021-11-09T08:59:55.000+00:00",
        // "modifiedUser":"test4add","uid":10,"username":"test4add",
        // "password":"6ECAC5594D441FEAD04B28678216E03D",
        // "salt":"64148DBB-1A4C-4243-930E-5DA40644EA6B","isDelete":0}}
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