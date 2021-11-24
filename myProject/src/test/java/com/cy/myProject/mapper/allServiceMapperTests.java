package com.cy.myProject.mapper;

import com.cy.myProject.Mapper.LoungeMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class allServiceMapperTests {
    @Autowired
    private LoungeMapper loungeMapper;
//    @Autowired
//    private LoungeMapper loungeMapper;
//    @Autowired
//    private luggageMapper luggageMapper;
//    @Autowired
//    private MealMapper mealMapper;
//    @Autowired
//    private PickUpMapper pickUpMapper;

    @Test
    public void findhotel(){
        System.out.println(loungeMapper.getloungebyName("Vip"));
    }



}
