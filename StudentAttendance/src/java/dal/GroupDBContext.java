/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Group;
import model.Lecture;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class GroupDBContext {

    ArrayList<Group> db = new ArrayList<>();
    ArrayList<Student> student = new ArrayList<>();

    public GroupDBContext() {
        student.add(new Student(1, "Vu Minh Quan"));
        db.add(new Group(1, student, new Lecture("ThomLT2"), "IOT1601_MAS291"));
        db.add(new Group(2, student, new Lecture("DungLTK"), "IOT1601_JPD123"));
        db.add(new Group(3, student, new Lecture("SonNT5"), "IOT1601_PRJ301"));

    }

    public ArrayList<Group> getList() {
        return db;
    }
    
    public ArrayList<Group> getList(int id){
        ArrayList<Group> rs = new ArrayList<>();
        for (Group group : db) {
            for (Student student1 : group.getStudent()) {
                if(student1.getId() == id){
                    rs.add(group);
                }
            }
        }
        return rs;
    }
    public ArrayList<Group> getList(String id){
        ArrayList<Group> rs = new ArrayList<>();
        for (Group group : db) {
            if(group.getLecture().getId().equalsIgnoreCase(id)){
                rs.add(group);
            }
        }
        return rs;
    }
    
}
