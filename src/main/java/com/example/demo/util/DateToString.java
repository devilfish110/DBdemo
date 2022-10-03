package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
    private static java.util.Date date;
    public static Date toDate(String Date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String tString(Date Date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(Date);
    }
}
