package com.cy.myProject.service;

import com.cy.myProject.entity.User;
import com.cy.myProject.service.ex.UserNotFoundException;


public interface IUserService {

void reg(User user);

User login(String username,String password);
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
