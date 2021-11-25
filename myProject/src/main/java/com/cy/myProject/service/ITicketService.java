package com.cy.myProject.service;


import com.cy.myProject.entity.Flight;

import java.sql.Date;
import java.util.List;

public interface ITicketService {

    List<Flight> getAllticket();


    List<Flight> getPartticket(Date flightDay, String fromLocation, String toLocation );

    Flight getTicketByFlightId(Integer FlightId);


    void updateFlightNumByflghtId(Integer FlightId);

    void noticket(Integer FlightId);
}

