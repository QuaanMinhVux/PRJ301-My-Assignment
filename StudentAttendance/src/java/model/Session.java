/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author MSI_GF63
 */
public class Session {
    private int id;
    private String name;
    private Date date;
    private int slot;
    private String room;
    private Group group;
    private Attendance attendance;

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
    public Session() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Session(int id, String name, Date date, int slot, String room, Group group, Attendance attendance) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.slot = slot;
        this.room = room;
        this.group = group;
        this.attendance = attendance;
    }

    public Session(int id, String name, Date date, int slot, String room, Group group) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.slot = slot;
        this.room = room;
        this.group = group;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
}
