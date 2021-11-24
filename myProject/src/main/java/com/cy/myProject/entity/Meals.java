package com.cy.myProject.entity;

import java.util.Objects;

public class Meals {
    private Integer mealId;
    private String name;
    private Integer price;


    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
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
        if (!(o instanceof Meals)) return false;
        Meals meals = (Meals) o;
        return Objects.equals(getMealId(), meals.getMealId()) && Objects.equals(getName(), meals.getName()) && Objects.equals(getPrice(), meals.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMealId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Meals{" +
                "mealId=" + mealId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
