package com.cy.myProject.controller;


import com.cy.myProject.entity.Passenger;
import com.cy.myProject.service.IPassengerService;

import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController extends BaseController{
    @Autowired
    private IPassengerService iPassengerService;

    @RequestMapping("insert_passenger")
    public JsonResult<Void> insertPassenger(Passenger passenger, HttpSession session){
        Integer uid =getUidFromSession(session);
        String username= getUsernameFromSession(session);
        iPassengerService.insertPassenger(passenger,uid,username);
        return new  JsonResult<Void>(ok);

    }
    @RequestMapping({"/",""})
    public  JsonResult<List<Passenger>> getPassengerByuid(HttpSession session){
                   Integer uid=  getUidFromSession(session);
        List<Passenger> data = iPassengerService.getAllPassengerbyUid(uid);
        System.out.println(data.toString());
        return new JsonResult<>(ok,data);
    }
}