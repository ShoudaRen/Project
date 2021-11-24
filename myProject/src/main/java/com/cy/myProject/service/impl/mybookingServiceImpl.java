package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.MybookingMapper;
import com.cy.myProject.Mapper.passengerMapper;
import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.entity.Passenger;
import com.cy.myProject.service.IPassengerService;
import com.cy.myProject.service.MyBookingService;
import com.cy.myProject.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class mybookingServiceImpl implements MyBookingService {
    @Autowired
    private MybookingMapper mybookingMapper;


    @Override
    public MyBooking insertService(MyBooking myBooking,
                                Integer uid,
                                Integer flightId, String username,
                                Integer classPrice,String mySeat,String meals,String pickup,
                                String transitHotel,String transitLounge,String specialServices,
                                Integer payStatus,String extraLuggage) {
        myBooking.setUid(uid);
        myBooking.setFlightId(flightId);
        myBooking.setMySeat(mySeat);
        myBooking.setClassPrice(classPrice);
        myBooking.setMeals(meals);
        myBooking.setPickup(pickup);
        myBooking.setTransitHotel(transitHotel);
        myBooking.setTransitLounge(transitLounge);
        myBooking.setSpecialServices(specialServices);
        myBooking.setPayStatus(payStatus);
        myBooking.setExtraLuggage(extraLuggage);
        myBooking.setCreatedTime(new Date());
        myBooking.setModifiedTime(new Date());
        myBooking.setCreatedUser(username);
        myBooking.setModifiedUser(username);
        Integer rows =mybookingMapper.insertBookingDetail(myBooking);
        if (rows!=1){
            throw new InsertException("insert exception");

        }

        return myBooking;
    }

    @Override
    public MyBooking findMybookByRef(Integer reference) {
       MyBooking myBooking= mybookingMapper.findServiceByRef(reference);
        if (myBooking==null){
            throw new BookingNotFoundException("no Booking exist");
        }
        return myBooking;
    }

    @Override
    public void updatepaidsercice(Integer reference, Integer mealPrice, Integer pickupPirce, Integer hotelPrice, Integer loungePrice, Integer luggagePrice) {
        mybookingMapper.updateServicePrice(reference,mealPrice,pickupPirce,hotelPrice,loungePrice,luggagePrice);
    }

    @Override
    public void updateTotalPriceByRef(Integer reference, Integer totalPrice) {
        mybookingMapper.updateAllPriceToDataBase(reference,totalPrice);
    }

    @Override
    public Integer getAllpriceByRef(Integer reference) {
        Integer allPrice= mybookingMapper.getAllPriceByReference(reference);
        return allPrice;
    }



}
