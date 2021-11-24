package com.cy.myProject.service;



import com.cy.myProject.entity.MyBooking;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class AllServiceTests {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private LoungeService loungeService;
    @Autowired
    private MealService mealService;
    @Autowired
    private LuggageService luggageService;
    @Autowired
    private  pickUpService pickUpService;


    @Test
    public  void  testhotel(){
        System.out.println(hotelService.getPirceByname("Express Hotel"));;
    }

    @Test
    public  void  testlougeService(){
        System.out.println(loungeService.getpricebyName("Normal"));;
    }
    @Test
    public  void  testluggervice(){
        System.out.println(luggageService.getLuggagePriceByName("40KG"));;
    }
    @Test
    public  void  testmealService(){
        System.out.println(mealService.getMealPriceByName("Fish and Chips"));;
    }
    @Test
    public  void  testcarService(){
        System.out.println(pickUpService.getCarPriceByName("Porsche"));;
    }

}


