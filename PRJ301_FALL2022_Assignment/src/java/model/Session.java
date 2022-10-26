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
public class Session {
    private int id;
    private Group group;
    private Room room;
    private Date date;
    private Time_Slot t;
    private int index;
    private Lecture lecture;
    private Week w;
    private ArrayList<Attendance> att = new ArrayList<>();
    private boolean attended;

    public Week getW() {
        return w;
    }

    public void setW(Week w) {
        this.w = w;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Attendance> getAtt() {
        return att;
    }

    public void setAtt(ArrayList<Attendance> att) {
        this.att = att;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time_Slot getT() {
        return t;
    }

    public void setT(Time_Slot t) {
        this.t = t;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
    
    
}
