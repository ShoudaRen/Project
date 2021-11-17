package com.cy.myProject.Mapper;


import com.cy.myProject.entity.TicketSearch;

import java.util.List;

public interface TickMapper {

       List<TicketSearch> findTick (String flightDay,
                                String fromLocation, String toLocation,
                                Integer AdultNum,
                                Integer childrenNum, Integer infantsNum,
                                Integer disableNum, String classType);

//       void updateFlightNum(Integer flightId, Integer AdultNum,
//                                  Integer childrenNum,
//                                  Integer infantsNum,
//                                  Integer disableNum);

       List<TicketSearch> findAllTicket ();
}
