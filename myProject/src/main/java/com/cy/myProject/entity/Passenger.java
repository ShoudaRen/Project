package com.cy.myProject.entity;

import java.util.Objects;

public class Passenger extends BaseEntity {

    int passengerId;
    int uid;
    String lastname;
    String firstname;
    String passport;
    String passportExpire;
    String email;
    String mobilePhone;
    int isDefault; // 0 defaut//1
    int isDelete;

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassportExpire() {
        return passportExpire;
    }

    public void setPassportExpire(String passportExpire) {
        this.passportExpire = passportExpire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return getPassengerId() == passenger.getPassengerId() && getUid() == passenger.getUid() && getIsDefault() == passenger.getIsDefault() && getIsDelete() == passenger.getIsDelete() && Objects.equals(getLastname(), passenger.getLastname()) && Objects.equals(getFirstname(), passenger.getFirstname()) && Objects.equals(getPassport(), passenger.getPassport()) && Objects.equals(getPassportExpire(), passenger.getPassportExpire()) && Objects.equals(getEmail(), passenger.getEmail()) && Objects.equals(getMobilePhone(), passenger.getMobilePhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPassengerId(), getUid(), getLastname(), getFirstname(), getPassport(), getPassportExpire(), getEmail(), getMobilePhone(), getIsDefault(), getIsDelete());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", uid=" + uid +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", passport='" + passport + '\'' +
                ", passportExpire='" + passportExpire + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", isDefault=" + isDefault +
                ", isDelete=" + isDelete +
                '}';
    }
}
