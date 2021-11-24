package com.cy.myProject.entity;

import java.util.Objects;

public class lounge {
    private Integer loungeId;
    private String  name;
    private Integer price;


    public Integer getLoungeId() {
        return loungeId;
    }

    public void setLoungeId(Integer loungeId) {
        this.loungeId = loungeId;
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
        if (!(o instanceof lounge)) return false;
        lounge lounge = (lounge) o;
        return Objects.equals(getLoungeId(), lounge.getLoungeId()) && Objects.equals(getName(), lounge.getName()) && Objects.equals(getPrice(), lounge.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoungeId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "lounge{" +
                "loungeId=" + loungeId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
