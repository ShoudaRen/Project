package com.cy.myProject.controller;


import com.cy.myProject.entity.Flight;
import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.service.ITicketService;
import com.cy.myProject.service.MyBookingService;
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
   tembooking = booking;
        return new  JsonResult<Void>(ok);
    }

    @RequestMapping("show_service")
    public JsonResult<MyBooking> showService(){
        return new JsonResult<MyBooking>(ok,tembooking);
    }

//未使用
    @RequestMapping("find_service")
    public JsonResult<MyBooking> findMyServiceByRef(Integer reference){
       MyBooking data=  myBookingService.findMybookByRef(reference);
        return new JsonResult<MyBooking>(ok,data);
    }
}

