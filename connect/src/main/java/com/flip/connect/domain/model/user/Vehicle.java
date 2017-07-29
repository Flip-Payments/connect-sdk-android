package com.flip.connect.domain.model.user;

/**
 * Created by ltorres on 28/07/2017.
 */

public class Vehicle {
    private String licensePlate;
    private String licensePlateCity;
    private String licensePlateState;
    private String licensePlateCountry;

    public Vehicle(String licensePlate, String licensePlateCity, String licensePlateState, String licensePlateCountry) {
        this.licensePlate = licensePlate;
        this.licensePlateCity = licensePlateCity;
        this.licensePlateState = licensePlateState;
        this.licensePlateCountry = licensePlateCountry;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlateCity() {
        return licensePlateCity;
    }

    public void setLicensePlateCity(String licensePlateCity) {
        this.licensePlateCity = licensePlateCity;
    }

    public String getLicensePlateState() {
        return licensePlateState;
    }

    public void setLicensePlateState(String licensePlateState) {
        this.licensePlateState = licensePlateState;
    }

    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }

    public void setLicensePlateCountry(String licensePlateCountry) {
        this.licensePlateCountry = licensePlateCountry;
    }
}
