/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author MSI_GF63
 */
public class DateTimeHelper {
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static java.util.Date toDateUtil(java.sql.Date d) {
        java.util.Date date = new java.util.Date(d.getTime());
        date = removeTime(date);
        return date;
    }

    public static java.sql.Date toDateSql(java.util.Date date) {
        date= removeTime(date);
        return new java.sql.Date(date.getTime());
    }

   
    
    public static Date addDays(java.util.Date d, int days)
    {
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    public static ArrayList<java.sql.Date> 
        getDateList(java.sql.Date from, java.sql.Date to)
    {
        ArrayList<java.sql.Date> res = new ArrayList<>();
        int days = 0;
        java.util.Date new_from = toDateUtil(from);
        java.util.Date new_to = toDateUtil(to);
        while(true)
        {
            java.util.Date d = DateTimeHelper.addDays(new_from, days);
            res.add(toDateSql(d));
            days++;
            if(d.compareTo(new_to)>=0)
                break;
        }
        return res;
    }
    public static boolean isDay(java.sql.Date date){
        java.util.Date now = new java.util.Date();
        java.util.Date new_date = toDateUtil(date);
        now = removeTime(now);
        new_date = removeTime(new_date);
        return now.compareTo(new_date) == 0;
    } 
}
