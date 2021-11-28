package com.cy.myProject.Mapper;

import com.cy.myProject.entity.MyBooking;

import java.util.List;

public interface MybookingMapper {

    Integer insertBookingDetail(MyBooking myBooking);

    MyBooking findServiceByRef(Integer reference);

    void  updateServicePrice(Integer reference, Integer mealPrice,Integer pickupPirce,
                             Integer hotelPrice,Integer loungePrice,Integer luggagePrice );

    Integer getAllPriceByReference(Integer reference);

    void  updateAllPriceToDataBase(Integer reference, Integer totalPrice);

    void upatePassengerIdToDatebase(Integer reference, Integer passengerId);

    void updatePaymentStatus(Integer reference, Integer payStatus);

    List<MyBooking> FindallMyBookingByUid(Integer uid);

    void updateClassType(Integer reference, String classType);

    Integer deleteByRef(Integer reference);

    void updateServiceByRef(Integer reference, String meals, String pickup, String transitHotel, String transitLounge, String specialServices, String extraLuggage);

    //isdelte replace service price
    void ChangeServicePrice(Integer reference, Integer isDelete);

    List<MyBooking> selectUnPaidOrder(Integer uid);
}
