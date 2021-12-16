package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.passengerMapper;
import com.cy.myProject.entity.Passenger;
import org.apache.tomcat.jni.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@RunWith(SpringRunner.class)

public class PassengerMapperTests {
    @Autowired
    private passengerMapper passenger;

    @Test
    public  void insert(){
        Passenger passenger1 = new Passenger();
        passenger1.setUid(3);
        passenger1.setEmail("3434@qq.com");
        passenger.insert(passenger1);
    }
    @Test
    public  void count(){
      Integer count =   passenger.countByUid(3);
        System.out.println(count);
    }

    @Test
    public  void findpassengerbYuid(){
        List<Passenger> a ;
        a =passenger.findpassengerByUid(4);

        System.out.println(a);

    }
    @Test
    public  void findPassengerExistByPid(){
        System.out.println(passenger.findPassengerExistByPid(10));
    }
    @Test
    public  void  updateNonDefault(){
        passenger.updateNonDefault(4);
    }
    @Test
    public  void  updateDefaultPassengerByPid(){
   passenger.updateDefaultPassengerByPid(10,"SHOUDA" , new Date());
    }

    @Test
    public  void  DeletePassengerByPid(){

        passenger.deleteByPid(8);
    }
    @Test
    public  void findMordited(){

       Passenger passengerq= passenger.findlastModified(4);
        System.out.println(passengerq);
    }


}
