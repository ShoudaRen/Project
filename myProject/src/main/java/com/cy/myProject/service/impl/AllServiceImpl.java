package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.*;
import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.service.*;
import com.cy.myProject.service.ex.BookingNotFoundException;
import com.cy.myProject.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AllServiceImpl implements HotelService,
        LoungeService, LuggageService, MealService,pickUpService {
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private LoungeMapper loungeMapper;
    @Autowired
    private luggageMapper luggageMapper;
    @Autowired
    private MealMapper mealMapper;
    @Autowired
    private PickUpMapper pickUpMapper;



    @Override
    public Integer getPirceByname(String name) {
        Integer price = hotelMapper.getHotelbyName(name).getPrice();
        return  price;
    }

    @Override
    public Integer getpricebyName(String name) {
        Integer price =loungeMapper.getloungebyName(name).getPrice();
        return  price;
    }

    @Override
    public Integer getLuggagePriceByName(String name) {
        Integer price = luggageMapper.getLuaByName(name).getPrice();
        return price;
    }

    @Override
    public Integer getMealPriceByName(String name) {
        Integer price = mealMapper.getMealbyName(name).getPrice();
        return price;
    }

    @Override
    public Integer getCarPriceByName(String name) {
        Integer price=pickUpMapper.getcarByname(name).getPrice();
        return price;
    }
}
