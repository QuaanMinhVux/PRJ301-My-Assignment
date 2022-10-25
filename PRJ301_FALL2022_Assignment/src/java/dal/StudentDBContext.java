/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Student;
import model.Subject;
import model.Time_Slot;
import model.Week;

/**
 *
 * @author MSI_GF63
 */
public class StudentDBContext extends DBContext<Student> {

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int id) {
        Student s = null;
        try {
            String sql = "select s.stdid, s.stdname, g.gid, g.gname, g.sem, g.[year], su.subid, su.subname, l.lid, l.lname\n"
                    + "from Student s inner join [Student_Group] sg on s.stdid = sg.stdid\n"
                    + "inner join [Group] g on g.gid = sg.gid\n"
                    + "inner join [Subject] su on su.subid = g.subid\n"
                    + "inner join [Lecturer] l on l.lid = g.lid\n"
                    + "where s.stdid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (s == null) {
                    s = new Student();
                    s.setId(rs.getInt("stdid"));
                    s.setName(rs.getString("stdname"));
                }

                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));

                Lecture l = new Lecture();
                l.setId(rs.getInt("lid"));
                l.setName(rs.getString("lname"));

                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                g.setSem(rs.getString("sem"));
                g.setYear(rs.getInt("year"));
                g.setLecture(l);
                g.setSubject(sub);
                
                s.getGroup().add(g);
            }

            String sql1 = "select se.sesid, se.gid, se.[date], se.attanded, r.rid, r.rname, w.wid, w.[week], t.tid, t.[from], t.[to]\n"
                    + "from [Session] se\n"
                    + "inner join Room r on r.rid = se.rid\n"
                    + "inner join [Week] w on w.wid = se.wid\n"
                    + "inner join TimeSlot t on t.tid = se.tid";
            PreparedStatement stm_se = connection.prepareStatement(sql1);
            ResultSet rs_se = stm_se.executeQuery();
            
                while (rs_se.next()) {
                    for (Group group : s.getGroup()) {
                        if (group.getId() == rs_se.getInt("gid")) {
                            Room r = new Room();
                            r.setId(rs_se.getInt("rid"));
                            r.setName(rs_se.getString("rname"));

                            Week w = new Week();
                            w.setId(rs_se.getInt("wid"));
                            w.setWeek(rs_se.getInt("week"));

                            Time_Slot t = new Time_Slot();
                            t.setId(rs_se.getInt("tid"));
                            t.setFrom(rs_se.getTime("from"));
                            t.setTo(rs_se.getTime("to"));

                            Session se = new Session();
                            se.setId(rs_se.getInt("sesid"));
                            se.setDate(rs_se.getDate("date"));
                            se.setAttended(rs_se.getBoolean("attanded"));
                            se.setRoom(r);
                            se.setT(t);
                            se.setW(w);

                            group.getSessions().add(se);
                        }
                    }
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    
    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
