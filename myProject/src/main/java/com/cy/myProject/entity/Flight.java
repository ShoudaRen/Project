package com.cy.myProject.entity;

import java.sql.Date;
import java.util.Objects;

public class Flight extends BaseEntity{
    private Integer flightId;
    private String  company;
    private String  flightName;
    private java.sql.Date flightDay;
    private String  takeOffTime;
    private String  fallingOffTime;
    private Integer duration;
    private String  fromLocation;
    private String  toLocation;
    private String  StayCity;
    private String  classType;
    private Integer AdultNum;
    private Integer childrenNum;
    private Integer infantsNum;
    private Integer disableNum;
    private Integer EcoPrice;
    private  Integer businessPrice;
    private  Integer FirstPrice;
    private Integer ChildPrice;
    private Integer infantPrice;
    private Integer disablePrice;
    private String entertainment;
    private  Integer isDelete;
    private Integer Onsale;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getFlightDay() {
        return flightDay;
    }

    public void setFlightDay(Date flightDay) {
        this.flightDay = flightDay;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public String getFallingOffTime() {
        return fallingOffTime;
    }

    public void setFallingOffTime(String fallingOffTime) {
        this.fallingOffTime = fallingOffTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getStayCity() {
        return StayCity;
    }

    public void setStayCity(String stayCity) {
        StayCity = stayCity;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Integer getAdultNum() {
        return AdultNum;
    }

    public void setAdultNum(Integer adultNum) {
        AdultNum = adultNum;
    }

    public Integer getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(Integer childrenNum) {
        this.childrenNum = childrenNum;
    }

    public Integer getInfantsNum() {
        return infantsNum;
    }

    public void setInfantsNum(Integer infantsNum) {
        this.infantsNum = infantsNum;
    }

    public Integer getDisableNum() {
        return disableNum;
    }

    public void setDisableNum(Integer disableNum) {
        this.disableNum = disableNum;
    }

    public Integer getEcoPrice() {
        return EcoPrice;
    }

    public void setEcoPrice(Integer ecoPrice) {
        EcoPrice = ecoPrice;
    }

    public Integer getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(Integer businessPrice) {
        this.businessPrice = businessPrice;
    }

    public Integer getFirstPrice() {
        return FirstPrice;
    }

    public void setFirstPrice(Integer firstPrice) {
        FirstPrice = firstPrice;
    }

    public Integer getChildPrice() {
        return ChildPrice;
    }

    public void setChildPrice(Integer childPrice) {
        ChildPrice = childPrice;
    }

    public Integer getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(Integer infantPrice) {
        this.infantPrice = infantPrice;
    }

    public Integer getDisablePrice() {
        return disablePrice;
    }

    public void setDisablePrice(Integer disablePrice) {
        this.disablePrice = disablePrice;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOnsale() {
        return Onsale;
    }

    public void setOnsale(Integer onsale) {
        Onsale = onsale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        if (!super.equals(o)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getFlightId(), flight.getFlightId()) && Objects.equals(getCompany(), flight.getCompany()) && Objects.equals(getFlightName(), flight.getFlightName()) && Objects.equals(getFlightDay(), flight.getFlightDay()) && Objects.equals(getTakeOffTime(), flight.getTakeOffTime()) && Objects.equals(getFallingOffTime(), flight.getFallingOffTime()) && Objects.equals(getDuration(), flight.getDuration()) && Objects.equals(getFromLocation(), flight.getFromLocation()) && Objects.equals(getToLocation(), flight.getToLocation()) && Objects.equals(getStayCity(), flight.getStayCity()) && Objects.equals(getClassType(), flight.getClassType()) && Objects.equals(getAdultNum(), flight.getAdultNum()) && Objects.equals(getChildrenNum(), flight.getChildrenNum()) && Objects.equals(getInfantsNum(), flight.getInfantsNum()) && Objects.equals(getDisableNum(), flight.getDisableNum()) && Objects.equals(getEcoPrice(), flight.getEcoPrice()) && Objects.equals(getBusinessPrice(), flight.getBusinessPrice()) && Objects.equals(getFirstPrice(), flight.getFirstPrice()) && Objects.equals(getChildPrice(), flight.getChildPrice()) && Objects.equals(getInfantPrice(), flight.getInfantPrice()) && Objects.equals(getDisablePrice(), flight.getDisablePrice()) && Objects.equals(getEntertainment(), flight.getEntertainment()) && Objects.equals(getIsDelete(), flight.getIsDelete()) && Objects.equals(getOnsale(), flight.getOnsale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFlightId(), getCompany(), getFlightName(), getFlightDay(), getTakeOffTime(), getFallingOffTime(), getDuration(), getFromLocation(), getToLocation(), getStayCity(), getClassType(), getAdultNum(), getChildrenNum(), getInfantsNum(), getDisableNum(), getEcoPrice(), getBusinessPrice(), getFirstPrice(), getChildPrice(), getInfantPrice(), getDisablePrice(), getEntertainment(), getIsDelete(), getOnsale());
    }


    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", company='" + company + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightDay=" + flightDay +
                ", takeOffTime='" + takeOffTime + '\'' +
                ", fallingOffTime='" + fallingOffTime + '\'' +
                ", duration=" + duration +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", StayCity='" + StayCity + '\'' +
                ", classType='" + classType + '\'' +
                ", AdultNum=" + AdultNum +
                ", childrenNum=" + childrenNum +
                ", infantsNum=" + infantsNum +
                ", disableNum=" + disableNum +
                ", EcoPrice=" + EcoPrice +
                ", businessPrice=" + businessPrice +
                ", FirstPrice=" + FirstPrice +
                ", ChildPrice=" + ChildPrice +
                ", infantPrice=" + infantPrice +
                ", disablePrice=" + disablePrice +
                ", entertainment='" + entertainment + '\'' +
                ", isDelete=" + isDelete +
                ", Onsale=" + Onsale +
                '}';
    }
}
