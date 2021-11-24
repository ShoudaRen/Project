package com.cy.myProject.entity;

import java.util.Objects;

public class Luggage {
    private Integer luggageId;
    private String  name;
    private Integer price;

    public Integer getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(Integer luggageId) {
        this.luggageId = luggageId;
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
        if (!(o instanceof Luggage)) return false;
        Luggage luggage = (Luggage) o;
        return Objects.equals(getLuggageId(), luggage.getLuggageId()) && Objects.equals(getName(), luggage.getName()) && Objects.equals(getPrice(), luggage.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLuggageId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "luggageId=" + luggageId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
