package com.flip.connect.data.model.tempProfile;

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

class Data {
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