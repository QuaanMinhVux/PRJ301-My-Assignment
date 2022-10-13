/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Group;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class StudentDBContext {
    ArrayList<Student> db = new ArrayList<>();
    public StudentDBContext(){
        db.add(new Student(1, "Vu Minh Quan"));
    }
    public Student getStudentByID(int id){
        Student s = new Student();
        for (Student student : db) {
            if(student.getId() == id){
                s = student;
                break;
            }
        }
        return s;
    }
    public boolean checkStudent(int id){
        boolean res = false;
        for (Student student : db) {
            if(student.getId() == id){
                res = true;
                break;
            }
        }
        return res;
    }
    public ArrayList<Student> getStudent(int id){
        GroupDBContext gdb = new GroupDBContext();
        ArrayList<Group> db =gdb.getList();
        ArrayList<Student> rs = new ArrayList<>();
        for (Group group : db) {
            if(group.getGroup_id() == id){
                rs = group.getStudent();
            }
        }
        return rs;
    }
    
}
