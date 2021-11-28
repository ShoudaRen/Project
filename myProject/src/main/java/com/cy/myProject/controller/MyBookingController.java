package com.cy.myProject.controller;

import com.cy.myProject.entity.Flight;
import com.cy.myProject.entity.MyBooking;
import com.cy.myProject.entity.Passenger;
import com.cy.myProject.service.*;
import com.cy.myProject.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("allMyBooking")
public class MyBookingController extends BaseController {
    @Autowired
    private MyBookingService myBookingService;
    @Autowired
    private ITicketService iTicketService;
    @Autowired
    private IPassengerService iPassengerService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private LoungeService loungeService;
    @Autowired
    private MealService mealService;
    @Autowired
    private LuggageService luggageService;
    @Autowired
    private  pickUpService pickUpService;

    private Flight temFlight;
    private MyBooking temMyBooking;
    private Passenger tempassenger;

    @RequestMapping({"/", ""})
    public JsonResult<List<MyBooking>> findAllBookingByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<MyBooking> data = myBookingService.findAllBookingByUid(uid);
        return new JsonResult<>(ok, data);
    }

    //@PathVariable have to be used to delever
    @RequestMapping("{passengerId}/get_a_passenger")
    public JsonResult<Passenger> setDefault(@PathVariable("passengerId") Integer passengerId) {
        Passenger data = iPassengerService.findPassengerBypid(passengerId);
        tempassenger = data;
        return new JsonResult<>(ok, data);
    }
    @RequestMapping("{reference}/get_service")
    public JsonResult<MyBooking> findMyServiceByRef(@PathVariable("reference")Integer reference){
        MyBooking data=  myBookingService.findMybookByRef(reference);
        temMyBooking=data;
        return new JsonResult<>(ok,data);
    }
    @RequestMapping("{flightId}/get_myflight")
    public JsonResult<Flight> getTicketByFlightId(@PathVariable("flightId") Integer flightId) {
        Flight data = iTicketService.getTicketByFlightId(flightId);
        temFlight= data;
        return new JsonResult<>(ok, data);
    }

    @RequestMapping("getPassenger")
    public JsonResult<Passenger> getPassenger() {
        return new JsonResult<>(ok, tempassenger);
    }
    @RequestMapping("getFlight")
    public JsonResult<Flight> getFlight() {
        return new JsonResult<>(ok, temFlight);
    }
    @RequestMapping("getService")
    public JsonResult<MyBooking> getService() {
        return new JsonResult<>(ok, temMyBooking);
    }

    @RequestMapping("delete")
  public JsonResult<Void> deleteBookingByRef(){
        myBookingService.deleteByRef(temMyBooking.getReference());
        return new JsonResult<>(ok);
    }

    @RequestMapping("updates_service")
    public JsonResult<Void> updateSer(String meals, String pickup, String transitHotel, String transitLounge, String specialServices, String extraLuggage){
        myBookingService.updateServiceByRef(temMyBooking.getReference(), meals,pickup,transitHotel,transitLounge,specialServices, extraLuggage);
        temMyBooking.setPickup(pickup);
        temMyBooking.setMeals( meals);
        temMyBooking.setExtraLuggage(extraLuggage);
        temMyBooking.setTransitLounge(transitLounge);
        temMyBooking.setTransitHotel(transitHotel);
        temMyBooking.setSpecialServices(specialServices);

        Integer hotelPrice = hotelService.getPirceByname(transitHotel);
        Integer loungePrice=loungeService.getpricebyName(transitLounge);
        Integer luggagePrice=luggageService.getLuggagePriceByName(extraLuggage);
        Integer mealPrice=mealService.getMealPriceByName(meals);
        Integer carPrice=pickUpService.getCarPriceByName(pickup);
        temMyBooking.setMealPrice(mealPrice);
        temMyBooking.setLoungePrice(loungePrice);
        temMyBooking.setLuggagePrice(luggagePrice);
        temMyBooking.setPickupPirce(carPrice);
        temMyBooking.setHotelPrice(hotelPrice);
        Integer ref = temMyBooking.getReference();

        myBookingService.updatepaidsercice(ref,mealPrice,carPrice,
                hotelPrice,loungePrice,luggagePrice);
        // obtain total price of flight+service
        Integer totalPrice=myBookingService.getAllpriceByRef(ref);
        temMyBooking.setTotalPrice(totalPrice);
        myBookingService.updateTotalPriceByRef(ref,totalPrice);

        //set service price
        Integer servicePrice =  temMyBooking.getTotalPrice()-temMyBooking.getClassPrice();
        myBookingService.updateServicePrice(ref, servicePrice);
        temMyBooking.setIsDelete(servicePrice);
        return new JsonResult<>(ok);
    }


    @RequestMapping("unpaid_Order")
    public JsonResult<List<MyBooking>> findUnpaidOrderByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<MyBooking> data = myBookingService.selectUnPaidOrder(uid);
        return new JsonResult<>(ok, data);
    }
    @RequestMapping("unpaid_payStatus")
    public JsonResult<Void> payStatus(){
        myBookingService.updatePaymentStatus(temMyBooking.getReference());
        return new JsonResult<>(ok);
    }
}