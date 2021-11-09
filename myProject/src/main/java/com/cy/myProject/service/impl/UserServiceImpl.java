package com.cy.myProject.service.impl;
//使用异常的情况执行实现
import com.cy.myProject.Mapper.UserMapper;
import com.cy.myProject.entity.User;
import com.cy.myProject.service.IUserService;
import com.cy.myProject.service.ex.InsertException;
import com.cy.myProject.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service  //不加这个报错  将当前类的对象交给Spring来管理，自动创建对象以及维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
    //先检测用户名是否被注册过 调用findByusername(username);
        User result= userMapper.findByUsername(user.getUsername());
         if(result!=null){
             //throw exception
             throw new UsernameDuplicatedException("The user name already exists");
         }else{
             //加密  md5算法的形式
          String oldPassword = user.getPassword();
          //获取salt(随机生成一个盐值)
             // UUID API，随机生成串
             String salt= UUID.randomUUID().toString().toUpperCase();
             //salt like a key , need to be documented
             user.setSalt(salt);
//             step 3 , put passward and salt as an integate to cy
           String MD5Password=  getMD5Password(oldPassword,salt);
           //加密之后重新设置到user对象
             user.setPassword(MD5Password);

//             Reset the configuration
             user.setIsDelete(0);
             user.setCreatedUser(user.getUsername());
             user.setModifiedUser(user.getUsername());
             Date date=new Date();
             user.setCreatedTime(date);
             user.setModifiedTime(date);
             //carry out register insert row
            Integer rows= userMapper.insert(user);
            if (rows!=1){
                throw new InsertException("oops! An unknown error");
            }
         }
    }

//    定义一个加密方法
    private String getMD5Password(String password, String salt){
        // DigestUtils 加密算法(需要进行3次加密)
        for (int i = 0; i < 3; i++) {
           password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        return password;

    }
}
