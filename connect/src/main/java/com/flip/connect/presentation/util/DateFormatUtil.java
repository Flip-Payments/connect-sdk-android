package com.flip.connect.presentation.util;

import java.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ltorres on 17/07/2017.
 */

public class DateFormatUtil {
//format = "dd 'de' MMMM";
    public static String formatDate(String date, String format) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR"));
        SimpleDateFormat formatter = new SimpleDateFormat(format, new Locale("pt", "BR"));
        Date returnDate = null;
        try {
            returnDate = inputDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatter.format(returnDate);
    }
    public static String formatDate(String date) {
        String format = "dd/MM/yyyy";
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR"));
        SimpleDateFormat formatter = new SimpleDateFormat(format, new Locale("pt", "BR"));
        Date returnDate = null;
        try {
            returnDate = inputDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatter.format(returnDate);
    }
}
