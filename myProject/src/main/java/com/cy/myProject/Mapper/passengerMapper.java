package com.cy.myProject.Mapper;


import com.cy.myProject.entity.Passenger;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Address;

import java.util.Date;
import java.util.List;

public interface passengerMapper {

    Integer insert(Passenger passenger);

    /**
     * 根据用户的id统计当前用户添加的所有乘机人
     * @param uid
     * @return
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的id查询用户的收货地址数据
     * @param uid  uid
     * @return  收获地址
     */
    List<Passenger>findpassengerByUid(Integer uid);


    /**
     * 默认功能设置
     * @param
     * @return
     */
    // if does not find , return null
    Passenger findPassengerExistByPid(Integer passengerId);
     // according user's uid to revise user's passenger ,return how many rows were influenced
     Integer updateNonDefault(Integer uid);
     // @Param 用来强制绑定数据库的参数名 防止名字不一致
     Integer updateDefaultPassengerByPid( @Param("passengerId")Integer passengerId,
                                          @Param("modifiedUser") String modifiedUser,
                                          @Param("modifiedTime")Date modifiedTime);

     Integer deleteByPid(Integer passengerId);
     //查询最后一个收货地址的顺序
     Passenger findlastModified(Integer uid);
}
