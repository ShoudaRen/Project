package com.cy.myProject.service;


import com.cy.myProject.entity.MyBooking;

public interface MyBookingService {


      MyBooking insertService(MyBooking myBooking,
                           Integer uid,
                           Integer flightId, String username,
                           Integer classPrice,String mySeat,String meals,String pickup,
                           String transitHotel,String transitLounge,String specialServices,
                           Integer payStatus,String extraLuggage);

     MyBooking findMybookByRef(Integer reference);
}

