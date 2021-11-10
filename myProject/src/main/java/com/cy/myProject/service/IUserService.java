package com.cy.myProject.service;

import com.cy.myProject.entity.User;
import com.cy.myProject.service.ex.UserNotFoundException;

//  用户模块业务层接口
public interface IUserService {
//       注册的功能，不需要要返回值
     void reg(User user); //    用户注册方法


    //返回User对象（当前匹配的用户数据），因为需要在页面中展示用户已登录,辅助其他功能； 没有的
//    的话显示Null
    User login(String username,String password);

}
