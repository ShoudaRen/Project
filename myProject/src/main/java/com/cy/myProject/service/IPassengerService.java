package com.cy.myProject.service;

import com.cy.myProject.entity.Passenger;

import java.util.List;

public interface IPassengerService {
//username 为了确保谁修改  uid是为定义是谁的地址 作为外键
    //void是因为插入数据不需要返回值
      void insertPassenger(Passenger passenger,Integer uid,String username);

      //根据ID来获得全部passenger
      List<Passenger> getAllPassengerbyUid(Integer uid);

      /**
       *
       * @param passengerId which one need revise
       * @param uid  all default
       * @param username  modified person
       */
  void setDefaultPassenger(Integer passengerId, Integer uid, String username);

  void delete(Integer passengerId,Integer uid, String username);
}

