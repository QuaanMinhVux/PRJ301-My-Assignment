/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.util.ArrayList;
import model.Attendance;
import model.Group;
import model.Lecture;
import model.Session;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class SessionDBContext {

    ArrayList<Session> db = new ArrayList<>();
    ArrayList<Student> student = new ArrayList<>();

    public SessionDBContext() {
        AttendanceDBContext adb = new AttendanceDBContext();
         student.add(new Student(1, "Vu Minh Quan"));
        db.add(new Session(1, "MAS291", Date.valueOf("2022-10-10"), 1, "DE-212", new Group(1, student, new Lecture("ThomLT2"), "IOT1601_MAS291"), new Attendance(1, 1, "Attend")));
        db.add(new Session(2, "JPD123", Date.valueOf("2022-10-10"), 3, "DE-416", new Group(2, student, new Lecture("DungLTK"), "IOT1601_JPD123"), new Attendance(1, 2, "Absent")));
        db.add(new Session(3, "PRj301", Date.valueOf("2022-10-11"), 3, "DE-416", new Group(3, student, new Lecture("SonNT5"), "IOT1601_PRJ301"), new Attendance(1, 3, "Attend")));
        db.add(new Session(4, "MAS291", Date.valueOf("2022-10-12"), 1, "DE-212", new Group(1, student, new Lecture("ThomLT2"), "IOT1601_MAS291"), new Attendance(1, 4, "Attend")));
        db.add(new Session(5, "JPD123", Date.valueOf("2022-10-12"), 3, "DE-416", new Group(2, student, new Lecture("DungLTK"), "IOT1601_JPD123"), new Attendance(1, 5, "Absent")));
        db.add(new Session(6, "PRj301", Date.valueOf("2022-10-13"), 2, "DE-416", new Group(3, student, new Lecture("SonNT5"), "IOT1601_JPD123"), new Attendance(1, 6, "Attend")));
        db.add(new Session(7, "PRj301", Date.valueOf("2022-10-13"), 3, "DE-416", new Group(3, student, new Lecture("SonNT5"), "IOT1601_JPD123"), new Attendance(1, 7, "Attend")));
        db.add(new Session(8, "MAS291", Date.valueOf("2022-10-14"), 1, "DE-212", new Group(1, student, new Lecture("ThomLT2"), "IOT1601_MAS291"), new Attendance(1, 7, "Future")));
        db.add(new Session(9, "JPD123", Date.valueOf("2022-10-14"), 3, "DE-416", new Group(2, student, new Lecture("DungLTK"), "IOT1601_JPD123"), new Attendance(1, 7, "Future")));
        
    }

    public ArrayList<Session> getList() {
        return db;
    }

    public ArrayList<Session> getList(int id) {
        ArrayList<Session> rs = new ArrayList<>();
        for (Session session : db) {
            for (Student student1 : session.getGroup().getStudent()) {
                if(student1.getId() == id){
                    rs.add(session);
                }
            }
        }
        return rs;
    }
    public ArrayList<Session> getListByGroup(int id){
        ArrayList<Session> rs = new ArrayList<>();
        for (Session session : db) {
            if(session.getGroup().getGroup_id() == id){
                rs.add(session);
            }
        }
        return rs;
    }
    public int Absent(ArrayList<Session> list){
        int count = 0;
        for (Session session : list) {
            if(session.getAttendance().getStatus().equalsIgnoreCase("absent")){
                count++;
            }
        }
        return count*100/list.size();
    }
    public ArrayList<Session> getList(String id){
        ArrayList<Session> rs = new ArrayList<>();
        for (Session session : db) {
            if(session.getGroup().getLecture().getId().equalsIgnoreCase(id)){
                rs.add(session);
            }
        }
        return rs;
    }
}
