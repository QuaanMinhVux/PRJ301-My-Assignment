/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Attendance;

/**
 *
 * @author MSI_GF63
 */
public class AttendanceDBContext {
    ArrayList<Attendance> db = new ArrayList<>();
    public AttendanceDBContext(){
        db.add(new Attendance(1, 1, "Attend"));
        db.add(new Attendance(1, 2, "Absent"));
        db.add(new Attendance(1, 3, "Attend"));
        db.add(new Attendance(1, 4, "Attend"));
        db.add(new Attendance(1, 5, "Absent"));
        db.add(new Attendance(1, 6, "Attend"));
        db.add(new Attendance(1, 7, "Attend"));
        
    }
    public ArrayList<Attendance> getAttendance(int id){
        ArrayList<Attendance> rs = new ArrayList<>();
        for (Attendance attendance : db) {
            if(attendance.getStudent_id() == id){
                rs.add(attendance);
            }
        }
        return rs;
    }
    public Attendance getAttendanceBySession(int id){
         Attendance rs = new Attendance();
        for (Attendance attendance : db) {
            if(attendance.getSession_id()== id){
                rs = attendance;
            }
        }
        return rs;
    }
}
