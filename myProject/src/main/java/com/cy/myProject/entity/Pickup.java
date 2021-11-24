package com.cy.myProject.entity;

import java.util.Objects;

public class Pickup {
    private Integer pkId;
    private String  name;
    private Integer price;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
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
        if (!(o instanceof Pickup)) return false;
        Pickup pickup = (Pickup) o;
        return Objects.equals(getPkId(), pickup.getPkId()) && Objects.equals(getName(), pickup.getName()) && Objects.equals(getPrice(), pickup.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "pkId=" + pkId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
