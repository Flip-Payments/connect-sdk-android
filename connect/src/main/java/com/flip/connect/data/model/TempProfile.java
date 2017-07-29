package com.flip.connect.data.model;

import com.flip.connect.domain.model.user.Address;
import com.flip.connect.domain.model.user.Document;
import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.Vehicle;

import java.util.List;

/**
 * Created by ltorres on 28/07/2017.
 */

public class TempProfile {
    private String applicationKey;
    private Data data;

    public TempProfile(PersonalData personalData, List<Vehicle> vehicles, List<Address> addresses, List<Phone> phones, List<Document> documents, List<Email> emails) {
        data = new Data(personalData, vehicles, addresses, phones, documents, emails);
    }

    private class Data {
        PersonalData personalData;
        List<Vehicle> vehicles;
        List<Address> addresses;
        List<Phone> phones;
        List<Document> documents;
        List<Email> emails;

        Data(PersonalData personalData, List<Vehicle> vehicles, List<Address> addresses, List<Phone> phones, List<Document> documents, List<Email> emails) {
            this.addresses = addresses;
            this.personalData = personalData;
            this.vehicles = vehicles;
            this.phones = phones;
            this.documents = documents;
            this.emails = emails;
        }
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public PersonalData getPersonalData() {
        return data.personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.data.personalData = personalData;
    }

    public List<Vehicle> getVehicles() {
        return data.vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.data.vehicles = vehicles;
    }

    public List<Address> getAddresses() {
        return data.addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.data.addresses = addresses;
    }

    public List<Phone> getPhones() {
        return data.phones;
    }

    public void setPhones(List<Phone> phones) {
        this.data.phones = phones;
    }

    public List<Document> getDocuments() {
        return data.documents;
    }

    public void setDocuments(List<Document> documents) {
        this.data.documents = documents;
    }

    public List<Email> getEmails() {
        return data.emails;
    }

    public void setEmails(List<Email> emails) {
        this.data.emails = emails;
    }
}
