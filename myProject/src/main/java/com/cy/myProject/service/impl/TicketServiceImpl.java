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
        List<Flight> tickets=tickMapper.findTick(fromLocation,toLocation,flightDay);

//        for (int i = 0; i <tickets.size() ; i++) {
//
//        }
        if (tickets.size()==0){

            throw new ticketNotFoundException("No ticket found");
        }
        return tickets;
    }

    @Override
    public Flight getTicketByFlightId(Integer FlightId) {
        Flight flight = tickMapper.bookAFlightbyflightId(FlightId);
        if (flight==null ){
            throw new ticketNotFoundException("the ticket does not exist");
        }

        return flight;
    }

    @Override
    public void updateFlightNumByflghtId(Integer FlightId) {
     Flight data= tickMapper.bookAFlightbyflightId( FlightId);
     if (data.getAdultNum()==0){
         throw new ticketNotFoundException("All tickets sold out!");
     }
        Integer ticket =data.getAdultNum()-1;
        tickMapper.updateFlightNumByflghtId(FlightId,ticket);
    }

    @Override
    public void noticket(Integer FlightId) {
        Flight flight=tickMapper.bookAFlightbyflightId(FlightId);
        if (flight.getAdultNum()==0){
            throw new ticketNotFoundException("tickets sold out");
        }
    }

    @Override
    public List<Flight> getOnSale() {
        List<Flight> ticket=tickMapper.findOnsale();
        return ticket;
    }

    @Override
    public List<Flight> getAllticketByecoPrice() {
        List<Flight> ticket= tickMapper.findAllTicketSortByPrice();
        return ticket;
    }

    @Override
    public List<Flight> getAllticketByTime() {
        List<Flight> ticket= tickMapper.findAllTicketSortByTime();
        return ticket;
    }

}
