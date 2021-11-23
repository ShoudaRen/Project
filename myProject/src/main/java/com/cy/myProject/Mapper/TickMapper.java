package com.cy.myProject.Mapper;


import com.cy.myProject.entity.Flight;

import java.sql.Date;
import java.util.List;

public interface TickMapper {

       List<Flight> findTick (String fromLocation, String toLocation, Date flightDay);

//       void updateFlightNum(Integer flightId, Integer AdultNum,
//                                  Integer childrenNum,
//                                  Integer infantsNum,
//                                  Integer disableNum);

       List<Flight> findAllTicket ();

       Flight bookAFlightbyflightId(Integer flightId);




}
