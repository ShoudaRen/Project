package com.cy.myProject.service;

import com.cy.myProject.entity.Passenger;

import java.util.List;

public interface IPassengerService {

      void insertPassenger(Passenger passenger,Integer uid,String username);

      List<Passenger> getAllPassengerbyUid(Integer uid);

      /**
       *
       * @param passengerId which one need revise
       * @param uid  all default
       * @param username  modified person
       */
  void setDefaultPassenger(Integer passengerId, Integer uid, String username);

  void delete(Integer passengerId,Integer uid, String username);

  Passenger findPassengerBypid(Integer passengerId);
}

