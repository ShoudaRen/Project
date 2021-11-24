package com.cy.myProject.controller;


import com.cy.myProject.entity.Flight;
import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.service.*;
import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController extends BaseController{
    @Autowired
    private MyBookingService myBookingService;
    @Autowired
    private ITicketService iTicketService;
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

    private  List<Flight>  dataStore = new ArrayList<>();
    private  Flight TheflightIneed= new Flight();
    private  int TemFlightId;
    private  int Temecoprice;
    private  int Tembusineprice;
    private  int Temfirstprice;
    private  int temRef;
    private  MyBooking tembooking;

    @RequestMapping({"/",""})
    public  JsonResult<List<Flight>> getAllTicket(){
        List<Flight> data =iTicketService.getAllticket();
        return new JsonResult<>(ok,data);
    }


    @RequestMapping("search_ticket")
    public  JsonResult<List<Flight>> getPartTicket(Date flightDay,
                                                   String fromLocation,
                                                   String toLocation){
        List<Flight> data =iTicketService.getPartticket(flightDay,fromLocation,toLocation);
        dataStore= data;
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("search_ticketPage")
    public  JsonResult<List<Flight>> getTicket(){
        return new JsonResult<>(ok,dataStore);
    }


    @RequestMapping("{flightId}/get_a_ticket")
    public  JsonResult<Flight> getTicketByFlightId(@PathVariable("flightId")Integer flightId){
     Flight data=  iTicketService.getTicketByFlightId(flightId);
        TheflightIneed=data;
        TemFlightId=data.getFlightId();
        Temecoprice=data.getEcoPrice();
        Tembusineprice=data.getBusinessPrice();
        Temfirstprice=data.getFirstPrice();

     return  new JsonResult<>(ok,data);
    }

    @RequestMapping("ticketInform")
        public  JsonResult<Flight> getTicketInform(){
            return  new JsonResult<>(ok,TheflightIneed);
        }


    @RequestMapping("booking")
    public JsonResult<Void> insertBooking(MyBooking myBooking,HttpSession session,String mySeat,String meals,
                                          String pickup,String transitHotel,String transitLounge,String specialServices
    ,Integer payStatus,String extraLuggage){
        Integer uid = getUidFromSession(session);
        String username= getUsernameFromSession(session);
      MyBooking booking=  myBookingService.insertService(myBooking, uid,TemFlightId,username
                ,Temecoprice, mySeat, meals,pickup,transitHotel,transitLounge,specialServices,payStatus,extraLuggage);
    // set all service price
        String hotel=booking.getTransitHotel();
        String lounge=booking.getTransitLounge();
        String luggage=booking.getExtraLuggage();
        String meal=booking.getMeals();
        String car=booking.getPickup();
       Integer hotelPrice = hotelService.getPirceByname(hotel);
       Integer loungePrice=loungeService.getpricebyName(lounge);
       Integer luggagePrice=luggageService.getLuggagePriceByName(luggage);
       Integer mealPrice=mealService.getMealPriceByName(meal);
       Integer carPrice=pickUpService.getCarPriceByName(car);
       booking.setMealPrice(mealPrice);
       booking.setLoungePrice(loungePrice);
       booking.setLuggagePrice(luggagePrice);
       booking.setPickupPirce(carPrice);
       booking.setHotelPrice(hotelPrice);
        Integer ref =booking.getReference();
        temRef=ref;
       myBookingService.updatepaidsercice(ref,mealPrice,carPrice,
                hotelPrice,loungePrice,luggagePrice);
      // obtain total price of flight+service
        Integer totalPrice=myBookingService.getAllpriceByRef(ref);
        booking.setTotalPrice(totalPrice);
        myBookingService.updateTotalPriceByRef(ref,totalPrice);
        // used for show method
        tembooking = booking;
        return new  JsonResult<Void>(ok);
    }

    @RequestMapping("booking_business")
    public JsonResult<Void> insertBookingBusiness(MyBooking myBooking,HttpSession session,String mySeat,String meals,
                                          String pickup,String transitHotel,String transitLounge,String specialServices
            ,Integer payStatus,String extraLuggage){
        Integer uid = getUidFromSession(session);
        String username= getUsernameFromSession(session);
        MyBooking booking=  myBookingService.insertService(myBooking, uid,TemFlightId,username
                ,Tembusineprice, mySeat, meals,pickup,transitHotel,transitLounge,specialServices,payStatus,extraLuggage);
        // set all service price
        String hotel=booking.getTransitHotel();
        String lounge=booking.getTransitLounge();
        String luggage=booking.getExtraLuggage();
        String meal=booking.getMeals();
        String car=booking.getPickup();
        Integer hotelPrice = hotelService.getPirceByname(hotel);
        Integer loungePrice=loungeService.getpricebyName(lounge);
        Integer luggagePrice=luggageService.getLuggagePriceByName(luggage);
        Integer mealPrice=mealService.getMealPriceByName(meal);
        Integer carPrice=pickUpService.getCarPriceByName(car);
        booking.setMealPrice(mealPrice);
        booking.setLoungePrice(loungePrice);
        booking.setLuggagePrice(luggagePrice);
        booking.setPickupPirce(carPrice);
        booking.setHotelPrice(hotelPrice);
        Integer ref =booking.getReference();
        temRef=ref;
        myBookingService.updatepaidsercice(ref,mealPrice,carPrice,
                hotelPrice,loungePrice,luggagePrice);
        // obtain total price of flight+service
        Integer totalPrice=myBookingService.getAllpriceByRef(ref);
        booking.setTotalPrice(totalPrice);
        myBookingService.updateTotalPriceByRef(ref,totalPrice);
        // used for show method
        tembooking = booking;
        return new  JsonResult<Void>(ok);
    }


    @RequestMapping("booking_first")
    public JsonResult<Void> insertBookingfirst(MyBooking myBooking,HttpSession session,String mySeat,String meals,
                                                  String pickup,String transitHotel,String transitLounge,String specialServices
            ,Integer payStatus,String extraLuggage){
        Integer uid = getUidFromSession(session);
        String username= getUsernameFromSession(session);
        MyBooking booking=  myBookingService.insertService(myBooking, uid,TemFlightId,username
                ,Temfirstprice, mySeat, meals,pickup,transitHotel,transitLounge,specialServices,payStatus,extraLuggage);
        // set all service price
        String hotel=booking.getTransitHotel();
        String lounge=booking.getTransitLounge();
        String luggage=booking.getExtraLuggage();
        String meal=booking.getMeals();
        String car=booking.getPickup();
        Integer hotelPrice = hotelService.getPirceByname(hotel);
        Integer loungePrice=loungeService.getpricebyName(lounge);
        Integer luggagePrice=luggageService.getLuggagePriceByName(luggage);
        Integer mealPrice=mealService.getMealPriceByName(meal);
        Integer carPrice=pickUpService.getCarPriceByName(car);
        booking.setMealPrice(mealPrice);
        booking.setLoungePrice(loungePrice);
        booking.setLuggagePrice(luggagePrice);
        booking.setPickupPirce(carPrice);
        booking.setHotelPrice(hotelPrice);
        Integer ref =booking.getReference();
        temRef=ref;
        myBookingService.updatepaidsercice(ref,mealPrice,carPrice,
                hotelPrice,loungePrice,luggagePrice);
        // obtain total price of flight+service
        Integer totalPrice=myBookingService.getAllpriceByRef(ref);
        booking.setTotalPrice(totalPrice);
        myBookingService.updateTotalPriceByRef(ref,totalPrice);
        // used for show method
        tembooking = booking;
        return new  JsonResult<Void>(ok);
    }







    @RequestMapping("show_service")
    public JsonResult<MyBooking> showService(){
        return new JsonResult<MyBooking>(ok,tembooking);
    }


    @RequestMapping("update_pid")
  public JsonResult<Void> updatePassengerIdByRef(Integer passengerId){
        myBookingService.updatePassengerId(temRef, passengerId);
        return  new  JsonResult<Void>(ok);
    }


    @RequestMapping("update_pay_status")
    public JsonResult<Void> updatePayStatusByRef(){
        myBookingService.updatePaymentStatus(temRef);
        return  new  JsonResult<Void>(ok);
    }
//未使用
    @RequestMapping("find_service")
    public JsonResult<MyBooking> findMyServiceByRef(Integer reference){
       MyBooking data=  myBookingService.findMybookByRef(reference);
        return new JsonResult<MyBooking>(ok,data);
    }
}

