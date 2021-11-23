package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.MybookingMapper;
import com.cy.myProject.entity.MyBooking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MybookingMapperTests {

    @Autowired
    private MybookingMapper mybookingMapper;

  @Test
    public void insert(){
      MyBooking myBooking = new MyBooking();
      myBooking.setUid(4);
      myBooking.setFlightId(3);
      myBooking.setPassengerId(11);
      myBooking.setMySeat("AF");
      myBooking.setClassPrice(100);
      myBooking.setMeals("Chicken 5GBP");
      myBooking.setPickup("Mercedes 50GBP");
      myBooking.setTransitHotel( "Offical Hotel 0GBP");
      myBooking.setTransitLounge("Normal 49GBP");
      myBooking.setSpecialServices("None");
      myBooking.setPayStatus(0);
      myBooking.setExtraLuggage("10KG 30GBP");
     Integer rows= mybookingMapper.insertBookingDetail(myBooking);
      System.out.println(rows);

  }
   @Test
    public void findservicebyRef(){
       System.out.println( mybookingMapper.findServiceByRef(100000019)); ;
    }

}
