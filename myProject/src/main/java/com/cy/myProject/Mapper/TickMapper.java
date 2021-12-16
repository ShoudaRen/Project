package com.cy.myProject.Mapper;


import com.cy.myProject.entity.Flight;

import java.sql.Date;
import java.util.List;

public interface TickMapper {

       List<Flight> findTick (String fromLocation, String toLocation, Date flightDay);

       List<Flight> findAllTicket ();

       //findflightByFlightLd
       Flight bookAFlightbyflightId(Integer flightId);

       void updateFlightNumByflghtId(Integer flightId, Integer AdultNum);

       List<Flight> findOnsale();

       List<Flight> findAllTicketSortByPrice ();
       List<Flight> findAllTicketSortByTime ();








}
