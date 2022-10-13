/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author MSI_GF63
 */
public class Group {
    private int group_id;
    private ArrayList<Student> student;
    private Lecture lecture;
    private String name;

    public Group() {
    }

    public Group(int group_id, ArrayList<Student> student, Lecture lecture, String name) {
        this.group_id = group_id;
        this.student = student;
        this.lecture = lecture;
        this.name = name;
    }

   

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    

    
    
}
