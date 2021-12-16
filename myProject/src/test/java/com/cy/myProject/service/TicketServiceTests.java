package com.cy.myProject.service;



import com.cy.myProject.entity.Passenger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@SpringBootTest // Indicates that the current class of the annotation is a test class and will not be packaged with the project
@RunWith(SpringRunner.class)//To start the unit test class (which cannot run without this annotation), pass a parameter that must be SpringRunner

public class TicketServiceTests {
    @Autowired
    private ITicketService iTicketService;

    @Test
    public void  getatickBFid(){
        System.out.println( iTicketService.getTicketByFlightId(2).getAdultNum());
    }


    @Test
    public void  getadultum(){
       iTicketService.noticket(2);
    }

    @Test
    public void  searchticket(){
        iTicketService.getPartticket(new Date(1),"","");
    }

    @Test
    public void  searchticketByEcoPRice(){
        System.out.println(iTicketService.getAllticketByecoPrice());
        ;
    }

    @Test
    public void  searchticketByTime(){
        System.out.println(iTicketService.getAllticketByTime());
    }

}



