package com.javarush.task.task29.task2909.user;

/**
 * Created by User2 on 26.02.2017.
 */
public class Address {
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    private String country;
    private String city;
    private String house;
}
