/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author MSI_GF63
 */
public class DateTimeHelper {
    public ArrayList<Date> getDate(Date from, Date to){
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
       ArrayList<Date> res = new ArrayList<>();
       Calendar c = Calendar.getInstance();
       Date date = from;
       c.setTime(date);
       res.add(from);
       while(true){
           c.roll(Calendar.DATE, true);
           String new_date = dateFormat.format(c.getTime());
           if(date.equals(to)){
               break;
           }
           date = Date.valueOf(new_date);
           res.add(date);
       }
       return res;
   }
}
