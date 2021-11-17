package com.cy.myProject.entity;

import java.util.Objects;

public class TicketSearch extends BaseEntity{
    private Integer flightId;
    private String  company;
    private String  flightName;
    private String  flightDay;
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
    private Integer entertainment;
    private  Integer isDelete;

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

    public String getFlightDay() {
        return flightDay;
    }

    public void setFlightDay(String flightDay) {
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

    public Integer getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Integer entertainment) {
        this.entertainment = entertainment;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketSearch)) return false;
        TicketSearch that = (TicketSearch) o;
        return Objects.equals(getFlightId(), that.getFlightId()) && Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getFlightName(), that.getFlightName()) && Objects.equals(getFlightDay(), that.getFlightDay()) && Objects.equals(getTakeOffTime(), that.getTakeOffTime()) && Objects.equals(getFallingOffTime(), that.getFallingOffTime()) && Objects.equals(getDuration(), that.getDuration()) && Objects.equals(getFromLocation(), that.getFromLocation()) && Objects.equals(getToLocation(), that.getToLocation()) && Objects.equals(getStayCity(), that.getStayCity()) && Objects.equals(getClassType(), that.getClassType()) && Objects.equals(getAdultNum(), that.getAdultNum()) && Objects.equals(getChildrenNum(), that.getChildrenNum()) && Objects.equals(getInfantsNum(), that.getInfantsNum()) && Objects.equals(getDisableNum(), that.getDisableNum()) && Objects.equals(getEcoPrice(), that.getEcoPrice()) && Objects.equals(getBusinessPrice(), that.getBusinessPrice()) && Objects.equals(getFirstPrice(), that.getFirstPrice()) && Objects.equals(getChildPrice(), that.getChildPrice()) && Objects.equals(getInfantPrice(), that.getInfantPrice()) && Objects.equals(getDisablePrice(), that.getDisablePrice()) && Objects.equals(getEntertainment(), that.getEntertainment()) && Objects.equals(getIsDelete(), that.getIsDelete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightId(), getCompany(), getFlightName(), getFlightDay(), getTakeOffTime(), getFallingOffTime(), getDuration(), getFromLocation(), getToLocation(), getStayCity(), getClassType(), getAdultNum(), getChildrenNum(), getInfantsNum(), getDisableNum(), getEcoPrice(), getBusinessPrice(), getFirstPrice(), getChildPrice(), getInfantPrice(), getDisablePrice(), getEntertainment(), getIsDelete());
    }

    @Override
    public String toString() {
        return "TicketSearch{" +
                "flightId=" + flightId +
                ", company='" + company + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightDay='" + flightDay + '\'' +
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
                ", entertainment=" + entertainment +
                ", isDelete=" + isDelete +
                '}';
    }
}
