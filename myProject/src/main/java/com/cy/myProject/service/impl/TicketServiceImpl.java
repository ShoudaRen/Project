package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.TickMapper;
import com.cy.myProject.entity.Flight;
import com.cy.myProject.service.ITicketService;
import com.cy.myProject.service.ex.ticketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private TickMapper tickMapper;


    @Override
    public List<Flight> getAllticket() {
        List<Flight> ticket= tickMapper.findAllTicket();
        Flight a = new Flight();
        return ticket;
    }

    @Override
    public List<Flight> getPartticket(Date flightDay, String fromLocation, String toLocation) {
        List<Flight> ticket=tickMapper.findTick(fromLocation,toLocation,flightDay);
        return ticket;
    }

    @Override
    public Flight getTicketByFlightId(Integer FlightId) {
        Flight flight = tickMapper.bookAFlightbyflightId(FlightId);
        if (flight==null ){
            throw new ticketNotFoundException("the ticket does not exist");
        }

        return flight;
    }


}
