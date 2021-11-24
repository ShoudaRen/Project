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

     void updatepaidsercice(Integer reference, Integer mealPrice,Integer pickupPirce,
                            Integer hotelPrice,Integer loungePrice,Integer luggagePrice);


     void updateTotalPriceByRef(Integer reference,Integer totalPrice);

     Integer getAllpriceByRef(Integer reference);

     void updatePassengerId(Integer  reference,Integer  passengerId);

     void updatePaymentStatus(Integer reference);
}

