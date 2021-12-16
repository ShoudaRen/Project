package com.cy.myProject.controller;
/**
 * 1:
 * The method parameter name must be the same as the form's name
 * Fields with the same name in the form object are automatically injected into the mapping object, so it's important to pay attention to how the form names are written!! .
 * In connection with a given parameter list, as long as the front end ensures that the name of the parameter given is the same as the name of the property in the object, the system will automatically inject it into the object
 * 2:
 * The method parameters meet the requirements of the server, nothing else
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

    @RequestMapping("reg")//
    //example:http://localhost:8080/users/reg?username=Tom123&password=123456
//    @ResponseBody // Indicates that the result of the method's response is sent to the front end in Json format
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<Void>(ok);

    }
    @RequestMapping("login")//路径
    public JsonResult<User> login(String username, String password , HttpSession session){
        User data=userService.login(username,password);
//        Complete binding of data to session objects (session global)
session.setAttribute("uid", data.getUid());
session.setAttribute("username", data.getUsername());
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<User>(ok,data);
      // example: http://localhost:8080/users/login?username=test4add&password=123
        //{"state":200,"data":{"createdUser":"test4add",
        // "createdTime":"2021-11-09T08:59:55.000+00:00",
        // "modifiedUser":"test4add","uid":10,"username":"test4add",
        // "password":"6ECAC5594D441FEAD04B28678216E03D",
        // "salt":"64148DBB-1A4C-4243-930E-5DA40644EA6B","isDelete":0}}
    }
    @RequestMapping("change_password")//路径
    public JsonResult<Void> changePassword (String oldPassword,
                                            String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username=getUsernameFromSession(session);
        userService.changePassword(uid,username,
                oldPassword,newPassword);
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
     * @param file
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
        // Returns true if the collection contains an element
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("the type does not be supported");
        }
        // Get the file storage path in the project... And then put in the pictures that the user uploaded
       String parent= session.getServletContext().getRealPath("upload");
// The File object points to this path and whether File exists
        File dir =new File(parent);
        if (!dir.exists()){
            dir.mkdir(); // Create the current directory
        }
        // To get the file name, the UUID tool generates a new string as the file name
            String OriginalFilename =file.getOriginalFilename();
            System.out.println(OriginalFilename);
            int index = OriginalFilename.lastIndexOf(".");
            String suffix = OriginalFilename.substring(index);
            String filename=UUID.randomUUID().toString().toUpperCase()+suffix;
        // Create an empty file
        File dest = new File(dir,filename);
        // Write the data from the parameter file to the empty file
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
    public void sessionClear ( HttpServletRequest request,HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("uid");
        request.getSession().invalidate();


    }











}