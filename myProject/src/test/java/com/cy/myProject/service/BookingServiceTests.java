package com.cy.myProject.service;



import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.entity.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class BookingServiceTests {
    @Autowired
    private MyBookingService myBookingService;


    @Test
    public void testmybookingInsert() {
        MyBooking myBooking = new MyBooking();

//        myBookingService.insertPassenger(myBooking,4,3,11,"shouda"
//        ,100,"SS","Chicken 5GBP","Mercedes 50GBP","Offical Hotel 0GBP",
//                "Normal 49GBP","None",0,"None");
    }
@Test
    public void  findMybookByRef(){
        System.out.println(myBookingService.findMybookByRef(100000019));
    }

}


