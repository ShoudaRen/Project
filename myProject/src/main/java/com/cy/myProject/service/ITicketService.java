package com.cy.myProject.service;


import com.cy.myProject.entity.TicketSearch;

import java.util.List;

public interface ITicketService {

    List<TicketSearch> getAllticket();


    List<TicketSearch> getPartticket(String flightDay,
                                     String fromLocation, String toLocation,
                                     Integer AdultNum,
                                     Integer childrenNum, Integer infantsNum,
                                     Integer disableNum, String classType);

}

