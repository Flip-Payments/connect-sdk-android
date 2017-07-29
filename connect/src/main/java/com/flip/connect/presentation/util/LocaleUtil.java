package com.flip.connect.presentation.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by ltorres on 20/07/2017.
 */

public class LocaleUtil {
    static ArrayList<String> countries = new ArrayList<>();
    static ArrayList<Locale> orderedLocales = new ArrayList<>();

    public static ArrayList<String> getAllCountryAvailable() {
        Locale[] locales = Locale.getAvailableLocales();
        countries = new ArrayList<>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry(new Locale("pt", "BR"));
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
                orderedLocales.add(locale);
            }
        }
        return countries;
    }

    public static int getPositionOfCountry(String country){
        getAllCountryAvailable();
        for(int i=0;i<orderedLocales.size();i++){
            if(orderedLocales.get(i).getCountry().equals(country)){
                return i;
            }
        }

        return 0;
    }

    public static String getCountry(int position){
        return orderedLocales.get(position).getCountry();
    }
}
