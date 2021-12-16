package com.cy.myProject.service;



import com.cy.myProject.entity.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PassengerServiceTests {
    @Autowired
    private IPassengerService iPassengerService;


    @Test
    public void testPassengerInsert(){
        Passenger passenger1 = new Passenger();
        passenger1.setUid(6);
        passenger1.setEmail("3434@qq.com");
        passenger1.setFirstname("sam");
        passenger1.setLastname("alice");passenger1.setPassport("FG123");
        iPassengerService.insertPassenger(passenger1,6,"test");
    }

    @Test
    public void testPassengerDefault(){
        iPassengerService.setDefaultPassenger(10, 4, "cc");

    }

    @Test
    public void testdelete(){
        iPassengerService.delete(9, 4, "shouda");
    }
   }



