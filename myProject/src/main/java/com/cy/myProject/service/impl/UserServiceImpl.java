package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.UserMapper;
import com.cy.myProject.entity.User;
import com.cy.myProject.service.IUserService;
import com.cy.myProject.service.ex.InsertException;
import com.cy.myProject.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
