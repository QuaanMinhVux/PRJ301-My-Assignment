/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Lecture;

/**
 *
 * @author MSI_GF63
 */
public class LectureDBContext {

    ArrayList<Lecture> db = new ArrayList<>();

    public LectureDBContext() {
        db.add(new Lecture("ThomLT2"));
        db.add(new Lecture("DungLTK"));
        db.add(new Lecture("SonNT5"));
    }

    public boolean checkLecture(String id) {
        boolean rs = false;
        for (Lecture lecture : db) {
            if (lecture.getId().equalsIgnoreCase(id)) {
                rs = true;
            }
        }
        return rs;
    }

    public Lecture getLecture(String id) {
        Lecture l = new Lecture();
        for (Lecture lecture : db) {
            if(lecture.getId().equalsIgnoreCase(id)){
                l = lecture;
            }
        }
        return l;
    }
}
