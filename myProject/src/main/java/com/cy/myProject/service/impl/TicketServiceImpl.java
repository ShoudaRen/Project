package com.cy.myProject.service.impl;

import com.cy.myProject.Mapper.TickMapper;
import com.cy.myProject.Mapper.passengerMapper;
import com.cy.myProject.entity.Passenger;
import com.cy.myProject.entity.TicketSearch;
import com.cy.myProject.service.IPassengerService;
import com.cy.myProject.service.ITicketService;
import com.cy.myProject.service.ex.InsertCountLimitedException;
import com.cy.myProject.service.ex.updateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private TickMapper tickMapper;


    @Override
    public List<TicketSearch> getAllticket() {
        List<TicketSearch> ticket= tickMapper.findAllTicket();
        return ticket;
    }

    @Override
    public List<TicketSearch> getPartticket(String flightDay, String fromLocation, String toLocation, Integer AdultNum, Integer childrenNum, Integer infantsNum, Integer disableNum, String classType) {
        List<TicketSearch> ticket=   tickMapper.findTick( flightDay,fromLocation,toLocation, AdultNum,childrenNum,infantsNum,disableNum,classType);
        return ticket;
    }
}
