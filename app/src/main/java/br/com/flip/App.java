package br.com.flip;

import android.app.Application;

import com.flip.connect.Connect;
import com.flip.connect.ConnectConfigurations;
import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.domain.model.user.Address;
import com.flip.connect.domain.model.user.Document;
import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrebelo on 07/08/2017.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ConnectConfigurations config = new ConnectConfigurations();

        config.setClientId("CLIENT_ID");
        config.setClientSecret("CLIENT_SECRET");
        config.setHost("HOST");
        config.setSchema("SCHEMA");
        config.setFingerPrintID("FINGER_PRINT_ID");

        config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION

        Connect.initializer(App.this, config);

    }





    private TempProfile feedTempProfile(){
        PersonalData personalData = new PersonalData("BR", "2017-12-02", 2, "masculine");

        Vehicle vehicle =new Vehicle("BBB 1234", null, "RJ", "BR");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        Address address = new Address("Rua Sem nome", "200", "ap 101", "work", "Ipanema", "Rio de Janeiro", "RJ", "22220-000", "perto do banco", "brasil");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        Phone phone = new Phone("mobile", "+5521998766574");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);

        Document document = new Document("cpf", "23989146408");
        List<Document> documents = new ArrayList<>();
        documents.add(document);

        Email email = new Email("connect@gmail.com");
        List<Email> emails = new ArrayList<>();
        emails.add(email);
        return new TempProfile(personalData, vehicles, addresses, phones, documents, emails);
    }

}
