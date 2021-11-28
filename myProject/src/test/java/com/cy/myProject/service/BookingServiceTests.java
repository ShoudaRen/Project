package com.cy.myProject.service;



import com.cy.myProject.entity.MyBooking;
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

    }
@Test
    public void  findMybookByRef(){
        System.out.println(myBookingService.findMybookByRef(100000054));
    }

@Test
    public void testupdatepaymentstatus(){
        myBookingService.updatePaymentStatus(100000025);
}
//    @Test
//    public void  updateService(){
//        myBookingService
//    }
  @Test
    public void deleteByRef(){
myBookingService.deleteByRef(100000056);
  }
  @Test
  public void selectUnPaidOrde(){
      System.out.println(myBookingService.selectUnPaidOrder(4));
    }
}


