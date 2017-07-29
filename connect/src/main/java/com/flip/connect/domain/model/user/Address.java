package com.flip.connect.domain.model.user;

/**
 * Created by ltorres on 28/07/2017.
 */

public class Address {
    private String street, number, complement, addressType, district, city, state, zipCode, addressReference, country;

    public Address(String street, String number, String complement, String addressType, String district, String city, String state, String zipCode, String addressReference, String country) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.addressType = addressType;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.addressReference = addressReference;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressReference() {
        return addressReference;
    }

    public void setAddressReference(String addressReference) {
        this.addressReference = addressReference;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
