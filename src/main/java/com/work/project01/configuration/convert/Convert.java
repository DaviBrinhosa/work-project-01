package com.work.project01.configuration.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
    public String dateToString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    public Date stringToDate(String dateString) {
        if (dateString == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
    		return null;
        }
    }
    
    public String longToString(Long value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
    
    public Long stringToLong(String longString) {
        if (longString == null) {
            return null;
        }
        try {
            return Long.parseLong(longString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
