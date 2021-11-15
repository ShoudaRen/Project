package com.cy.myProject.Mapper;
// user model interface

import com.cy.myProject.entity.User;
import org.apache.ibatis.annotations.Param;

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

    /**
     * @Param("SQL映射文件中#{}占位符中的变量名")： 当SQL语句的占位符和映射的接口方法参数名不一致时，
     * 需要将某个参数强行注入到某个占位符变量上时，可以以使用@Param这个注解来标注映射的关系
     * modify user's image according user's uid
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByuid(@Param("uid") Integer uid,
                              @Param("avatar")String avatar,
                              @Param("modifiedUser")String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}

