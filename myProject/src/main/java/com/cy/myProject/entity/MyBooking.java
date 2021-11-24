package com.cy.myProject.entity;

import java.util.Objects;

public class MyBooking  extends BaseEntity{

   private Integer reference;
    private Integer uid;
    private Integer flightId;
    private Integer passengerId;
    private String mySeat;
    private Integer classPrice;
    private String meals;
    private String pickup;
    private String transitHotel;
    private String transitLounge;
    private String specialServices;
    private String preSeat;
    private Integer totalPrice;
    private Integer payStatus;
    private String extraLuggage;
    private Integer isDelete;
    private Integer mealPrice;
    private Integer pickupPirce;
    private Integer hotelPrice;
    private Integer loungePrice;
    private Integer luggagePrice;

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getMySeat() {
        return mySeat;
    }

    public void setMySeat(String mySeat) {
        this.mySeat = mySeat;
    }

    public Integer getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(Integer classPrice) {
        this.classPrice = classPrice;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getTransitHotel() {
        return transitHotel;
    }

    public void setTransitHotel(String transitHotel) {
        this.transitHotel = transitHotel;
    }

    public String getTransitLounge() {
        return transitLounge;
    }

    public void setTransitLounge(String transitLounge) {
        this.transitLounge = transitLounge;
    }

    public String getSpecialServices() {
        return specialServices;
    }

    public void setSpecialServices(String specialServices) {
        this.specialServices = specialServices;
    }

    public String getPreSeat() {
        return preSeat;
    }

    public void setPreSeat(String preSeat) {
        this.preSeat = preSeat;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getExtraLuggage() {
        return extraLuggage;
    }

    public void setExtraLuggage(String extraLuggage) {
        this.extraLuggage = extraLuggage;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(Integer mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Integer getPickupPirce() {
        return pickupPirce;
    }

    public void setPickupPirce(Integer pickupPirce) {
        this.pickupPirce = pickupPirce;
    }

    public Integer getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(Integer hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Integer getLoungePrice() {
        return loungePrice;
    }

    public void setLoungePrice(Integer oungePrice) {
        this.loungePrice = oungePrice;
    }

    public Integer getLuggagePrice() {
        return luggagePrice;
    }

    public void setLuggagePrice(Integer luggagePrice) {
        this.luggagePrice = luggagePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBooking)) return false;
        if (!super.equals(o)) return false;
        MyBooking myBooking = (MyBooking) o;
        return Objects.equals(getReference(), myBooking.getReference()) && Objects.equals(getUid(), myBooking.getUid()) && Objects.equals(getFlightId(), myBooking.getFlightId()) && Objects.equals(getPassengerId(), myBooking.getPassengerId()) && Objects.equals(getMySeat(), myBooking.getMySeat()) && Objects.equals(getClassPrice(), myBooking.getClassPrice()) && Objects.equals(getMeals(), myBooking.getMeals()) && Objects.equals(getPickup(), myBooking.getPickup()) && Objects.equals(getTransitHotel(), myBooking.getTransitHotel()) && Objects.equals(getTransitLounge(), myBooking.getTransitLounge()) && Objects.equals(getSpecialServices(), myBooking.getSpecialServices()) && Objects.equals(getPreSeat(), myBooking.getPreSeat()) && Objects.equals(getTotalPrice(), myBooking.getTotalPrice()) && Objects.equals(getPayStatus(), myBooking.getPayStatus()) && Objects.equals(getExtraLuggage(), myBooking.getExtraLuggage()) && Objects.equals(getIsDelete(), myBooking.getIsDelete()) && Objects.equals(getMealPrice(), myBooking.getMealPrice()) && Objects.equals(getPickupPirce(), myBooking.getPickupPirce()) && Objects.equals(getHotelPrice(), myBooking.getHotelPrice()) && Objects.equals(getLoungePrice(), myBooking.getLoungePrice()) && Objects.equals(getLuggagePrice(), myBooking.getLuggagePrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getReference(), getUid(), getFlightId(), getPassengerId(), getMySeat(), getClassPrice(), getMeals(), getPickup(), getTransitHotel(), getTransitLounge(), getSpecialServices(), getPreSeat(), getTotalPrice(), getPayStatus(), getExtraLuggage(), getIsDelete(), getMealPrice(), getPickupPirce(), getHotelPrice(), getLoungePrice(), getLuggagePrice());
    }

    @Override
    public String toString() {
        return "MyBooking{" +
                "reference=" + reference +
                ", uid=" + uid +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", mySeat='" + mySeat + '\'' +
                ", classPrice=" + classPrice +
                ", meals='" + meals + '\'' +
                ", pickup='" + pickup + '\'' +
                ", transitHotel='" + transitHotel + '\'' +
                ", transitLounge='" + transitLounge + '\'' +
                ", specialServices='" + specialServices + '\'' +
                ", preSeat='" + preSeat + '\'' +
                ", totalPrice=" + totalPrice +
                ", payStatus=" + payStatus +
                ", extraLuggage='" + extraLuggage + '\'' +
                ", isDelete=" + isDelete +
                ", mealPrice=" + mealPrice +
                ", pickupPirce=" + pickupPirce +
                ", hotelPrice=" + hotelPrice +
                ", oungePrice=" + loungePrice +
                ", luggagePrice=" + luggagePrice +
                '}';
    }
}
