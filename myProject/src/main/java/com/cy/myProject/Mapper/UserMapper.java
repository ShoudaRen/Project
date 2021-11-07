package com.cy.myProject.Mapper;
// user model interface

import com.cy.myProject.entity.User;

public interface UserMapper {
    /**
     * insert user data
     * @param user user data
     * @return influenced line(add,delete,change ，根据返回值判断是否成功)
     */
    Integer insert(User user);

    /**
     * 根据用户名查询数据
     * @param username
     * @return If find data return data, else return null
     */
    User findByUsername(String username);
}
