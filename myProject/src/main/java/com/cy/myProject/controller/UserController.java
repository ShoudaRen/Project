package com.cy.myProject.controller;
/**
 * 1：
 * 方法参数名要和表单的name保持一致
 * 表单对象的同名字段会自动注入映射对象中，因此注重表单里名字的写法很重要！！,
 * 在连接给定的参数列表中，前端只要保证给的参数的名字和对象中属性的名字一致，系统就会自动地注入到对象中
 * 2：
 * 方法参数满足服务器所需的参数，别的不需要
 */

import com.cy.myProject.config.LoginInterceptorConfigurer;
import com.cy.myProject.controller.ex.*;
import com.cy.myProject.entity.User;
import com.cy.myProject.interceptor.LoginInterceptor;
import com.cy.myProject.service.IUserService;
import com.cy.myProject.service.ex.InsertException;
import com.cy.myProject.service.ex.UsernameDuplicatedException;
import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

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
    public JsonResult<User> login(String username, String password , HttpSession session){
        User data=userService.login(username,password);
//        向session对象中完成数据的绑定（session全局的）
session.setAttribute("uid", data.getUid());
session.setAttribute("username", data.getUsername());
//加上reference
//获取seesion中绑定的数据
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        //如果 userService.login(username,password);有异常会被
        // baseController里的@ExceptionHandler(ServiceException.class)捕获
        // 进而在handleException（）里进行处理， 没有异常直接返回JsonResult<User>(ok)给前端
        /**
         *  把data放进去传给前端 因为需要返回用户数据所以，需要data 类型为user
         */
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
    @RequestMapping("change_password")//路径
    /**String oldPassword, String newPassword, 参数名要和web form input 里的name保持一致
     * HttpSession 需要这个来传递user信息来更新前端数据
     */
    public JsonResult<Void> changePassword (String oldPassword,
                                            String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username=getUsernameFromSession(session);
        userService.changePassword(uid,username,
                oldPassword,newPassword);
        //因为不需要返回任何东西 所以 直接写ok
           return new  JsonResult<>(ok);
    }

//  return user to front end
    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
     User data =userService.getByuid(getUidFromSession(session));
     return new JsonResult<User>(ok,data) ;

    }

    @RequestMapping("change_info")
    public JsonResult<Void> updateInfo (User user,HttpSession session){

        Integer uid = getUidFromSession(session);
        String username=getUsernameFromSession(session);
        userService.changeInfo(uid,username,user);
        return new  JsonResult<>(ok);
    }

    /**
     *
     * @param avatar
     * @param session
     * @param file   MultipartFile自动把文件转化成数据包，可以接受任何类型的文件
     * @return
     */
    //  the max size of an image
    public static final int AVATAR_MAX_SIZE=10*1024*1024;
   //the type of a file update
   public static final List<String> AVATAR_TYPE= new ArrayList<>();
   static{
       AVATAR_TYPE.add("image/jpeg");
       AVATAR_TYPE.add("image/jpg");
       AVATAR_TYPE.add("image/png");
       AVATAR_TYPE.add("image/bmp");
       AVATAR_TYPE.add("image/gif");
   }
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar ( HttpSession session,
                                            @RequestParam("file") MultipartFile file){

        if (file.isEmpty()){
            throw new FileEmptyException("the file is empty");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("File size is out 10MB");
        }
        String contentType = file.getContentType();
        //如果集合包含了某个元素则返回true
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("the type does not be supported");
        }
        //在项目中获得文件储存的路径。。。然后把用户上传的图片放进去
       String parent= session.getServletContext().getRealPath("upload");
//   File 对象 指向这个路径，File是否存在
        File dir =new File(parent);
        if (!dir.exists()){
            dir.mkdir(); //创建当前目录
        }
            //获取到这个文件名称，UUID工具来生成一过热新的字符串作为文件名
            String OriginalFilename =file.getOriginalFilename();
            System.out.println(OriginalFilename);
            int index = OriginalFilename.lastIndexOf(".");
            String suffix = OriginalFilename.substring(index);
            String filename=UUID.randomUUID().toString().toUpperCase()+suffix;
        //创建一个空文件
        File dest = new File(dir,filename);
        //将参数file中的数据写入这个空文件中
        try {
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("file state exception");}
        catch (IOException e) {
           throw new FileUploadIOException("file read exception");
        }
        Integer uid = getUidFromSession(session);
        String username=getUsernameFromSession(session);
        String avatar ="/upload/"+filename;

        userService.changeAvatar(uid,avatar,username);
        return new  JsonResult<>(ok,avatar);
    }



    @RequestMapping("session_clear")
    public void sessionClear ( HttpServletRequest request){

        request.getSession().invalidate();

//        LoginInterceptorConfigurer loginInterceptorConfigurer = new LoginInterceptorConfigurer();
//        InterceptorRegistry registry = new InterceptorRegistry();
//        loginInterceptorConfigurer.addInterceptors(registry);

    }








    //没有base需要这样写
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