package com.cy.myProject.Mapper;

import com.cy.myProject.entity.MyBooking;

public interface MybookingMapper {

    Integer insertBookingDetail(MyBooking myBooking);

    MyBooking findServiceByRef(Integer reference);


    void updatePaymentStatus(Integer reference);
}
