package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.HotelMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class HotelMapperTests {

    @Autowired
    private HotelMapper hotelMapper;

  @Test
    public void insert(){
      System.out.println(hotelMapper.getHotelbyName("Sheraton").getPrice());
  }

}
