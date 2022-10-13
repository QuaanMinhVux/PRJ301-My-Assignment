/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Week;

/**
 *
 * @author MSI_GF63
 */
public class WeekDBContext {
    ArrayList<Week> db = new ArrayList<>();
    public WeekDBContext(){
        db.add(new Week(41, java.sql.Date.valueOf("2022-10-03"), java.sql.Date.valueOf("2022-10-9")));
        db.add(new Week(42, java.sql.Date.valueOf("2022-10-10"), java.sql.Date.valueOf("2022-10-16")));
        db.add(new Week(43, java.sql.Date.valueOf("2022-10-17"), java.sql.Date.valueOf("2022-10-23")));
    }
    public ArrayList<Week> getList(){
        return db;
    }
    public Week getWeek(int week){
        Week res = new Week();
        for (Week w : db) {
            if(w.getWeek() == week){
                res = w;
                break;
            }
        }
        return res;
    }
}
