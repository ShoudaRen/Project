package com.cy.myProject.Mapper;
// user model interface

import com.cy.myProject.entity.User;

import java.util.Date;
//数据库对应的信息
// 接口设定完成之后要在在映射文件中配置
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
    /**
     *
     * @param uid
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return  数据库增删改都会有返回值是一个受影响的行数，为了之后的方便要设成Integer
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    //如果有返回的是user对象
    User findByUid (Integer uid);

    /**
     * update user's information in database
     * @param user
     * @return
     */
    Integer updateInfoByUid(User user);
}

