/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author MSI_GF63
 */
public class Week {
    private int week;
    private java.sql.Date from;
    private java.sql.Date to;

    public Week() {
    }
    
    public Week(int week, Date from, Date to) {
        this.week = week;
        this.from = from;
        this.to = to;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) { 
        this.week = week;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
    

    
}
