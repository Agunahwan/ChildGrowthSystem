package com.agunahwanabsin.childgrowthsystem.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CommonLibrary {
    public static String getToday() {
        Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);

        return today;
    }

    public static String formattingDate(String tanggal) {
        String result = "";
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date = null;
        try {
            date = inputFormat.parse(tanggal);

            result = df.format(date);
        } catch (ParseException e) {
            result = tanggal;
            e.printStackTrace();
        }

        return result;
    }
}
