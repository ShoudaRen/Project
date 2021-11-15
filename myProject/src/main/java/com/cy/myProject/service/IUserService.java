package com.cy.myProject.service;

import com.cy.myProject.entity.User;
import com.cy.myProject.service.ex.UserNotFoundException;

//  用户模块业务层接口， 底层需要的信息,传给mapper层需要的数据
public interface IUserService {
//       注册的功能，不需要要返回值
void reg(User user); //    用户注册方法

    //返回User对象（当前匹配的用户数据），因为需要在页面中展示用户已登录,辅助其他功能； 没有的
    //    的话显示Null
User login(String username,String password);

    //    执行用户修改密码的新方法
void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * get user's uid
     * @param uid
     * @return return user object
     */
    User getByuid(Integer uid);

    /**
     *  update user's info in backend
     * @param uid
     * @param username
     * @param user  used to define modified time
     */
    void changeInfo(Integer uid,String username, User user);

    /**
     * update user's image
     * @param uid
     * @param avatar
     * @param username  used to define modified time
     */
    void changeAvatar(Integer uid,String avatar, String username);
}
