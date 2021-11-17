package com.cy.myProject.Mapper;


import com.cy.myProject.entity.Passenger;

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
}
