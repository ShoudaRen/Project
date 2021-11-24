package com.cy.myProject.mapper;



import com.cy.myProject.Mapper.MybookingMapper;
import com.cy.myProject.entity.MyBooking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
      myBooking.setHotelPrice(100);
      myBooking.setLuggagePrice(100);
      myBooking.setPickupPirce(100);
      myBooking.setLoungePrice(200);
      myBooking.setMealPrice(100);
     Integer rows= mybookingMapper.insertBookingDetail(myBooking);
      System.out.println(rows);

  }
   @Test
    public void findservicebyRef(){
       System.out.println( mybookingMapper.findServiceByRef(100000019)); ;
    }

    @Test
    public void  updateService(){
      mybookingMapper.updateServicePrice(100000017, 100,10, 12, 23, 34);
    }

    @Test
    public void sumAllPrice(){
        System.out.println(mybookingMapper.getAllPriceByReference(100000022));
    }

    @Test
    public void upadateAllPrice(){
        mybookingMapper.updateAllPriceToDataBase(100000022,407);
    }

}
