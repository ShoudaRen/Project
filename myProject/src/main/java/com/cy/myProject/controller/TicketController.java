package com.cy.myProject.controller;


import com.cy.myProject.entity.Flight;
import com.cy.myProject.service.ITicketService;
import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController extends BaseController{
    @Autowired
    private ITicketService iTicketService;
    private  List<Flight>  dataStore = new ArrayList<>();
    private  Flight TheflightIneed= new Flight();

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
     return  new JsonResult<>(ok,data);
    }

    @RequestMapping("ticketInform")
        public  JsonResult<Flight> getTicketInform(){
            return  new JsonResult<>(ok,TheflightIneed);
        }


//    @RequestMapping("{FlightId}/economy")
//    @RequestMapping("{FlightId}/business")
//    @RequestMapping("{FlightId}/first")
}