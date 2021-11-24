package com.cy.myProject.entity;

import java.util.Objects;

public class Hotel  extends BaseEntity{

    private Integer hotelId;
    private String  name;
    private Integer price;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getHotelId(), hotel.getHotelId()) && Objects.equals(getName(), hotel.getName()) && Objects.equals(getPrice(), hotel.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotelId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
