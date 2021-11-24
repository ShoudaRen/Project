package com.cy.myProject.Mapper;

import com.cy.myProject.entity.MyBooking;

public interface MybookingMapper {

    Integer insertBookingDetail(MyBooking myBooking);

    MyBooking findServiceByRef(Integer reference);

    void  updateServicePrice(Integer reference, Integer mealPrice,Integer pickupPirce,
                             Integer hotelPrice,Integer loungePrice,Integer luggagePrice );

    Integer getAllPriceByReference(Integer reference);

    void  updateAllPriceToDataBase(Integer reference, Integer totalPrice);

    void upatePassengerIdToDatebase(Integer reference, Integer passengerId);

    void updatePaymentStatus(Integer reference, Integer payStatus);
}
