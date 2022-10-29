/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Subject;
import model.Time_Slot;
import model.Week;

/**
 *
 * @author MSI_GF63
 */
public class LectureDBContext extends DBContext<Lecture> {

    @Override
    public void insert(Lecture model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecture model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecture model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lecture get(int id) {
        Lecture l = null;
        try {
            String lecture_sql = "select l.lid, l.lname, g.gid, g.gname, g.sem, g.[year], sub.subid, sub.subname, sub.subslot\n"
                    + "from [Lecturer] l inner join [Group] g on l.lid = g.lid\n"
                    + "inner join [Subject] sub on sub.subid = g.subid\n"
                    + "where l.lid = ?";
            PreparedStatement lecture_stm = connection.prepareStatement(lecture_sql);
            lecture_stm.setInt(1, id);
            ResultSet lecture_rs = lecture_stm.executeQuery();
            while (lecture_rs.next()) {
                if (l == null) {
                    l = new Lecture();
                    l.setId(lecture_rs.getInt("lid"));
                    l.setName(lecture_rs.getString("lname"));
                }
                Group g = new Group();
                g.setId(lecture_rs.getInt("gid"));
                g.setName(lecture_rs.getString("gname"));
                g.setSem(lecture_rs.getString("sem"));
                g.setYear(lecture_rs.getInt("year"));

                Subject sub = new Subject();
                sub.setId(lecture_rs.getInt("subid"));
                sub.setName(lecture_rs.getString("subname"));
                sub.setSlot(lecture_rs.getInt("subslot"));
                g.setSubject(sub);
                l.getGroup().add(g);
            }
            String session_sql = "select se.sesid, se.gid, se.[date], se.attanded, r.rid, r.rname, w.wid, w.[week], t.tid, t.[from], t.[to]\n"
                    + "from [Session] se\n"
                    + "inner join Room r on r.rid = se.rid\n"
                    + "inner join [Week] w on w.wid = se.wid\n"
                    + "inner join TimeSlot t on t.tid = se.tid";
            PreparedStatement session_stm = connection.prepareStatement(session_sql);
            ResultSet session_rs = session_stm.executeQuery();
            while(session_rs.next()){
                for (Group group : l.getGroup()) {
                        if (group.getId() == session_rs.getInt("gid")) {
                            Room r = new Room();
                            r.setId(session_rs.getInt("rid"));
                            r.setName(session_rs.getString("rname"));

                            Week w = new Week();
                            w.setId(session_rs.getInt("wid"));
                            w.setWeek(session_rs.getInt("week"));

                            Time_Slot t = new Time_Slot();
                            t.setId(session_rs.getInt("tid"));
                            t.setFrom(session_rs.getTime("from"));
                            t.setTo(session_rs.getTime("to"));

                            Session se = new Session();
                            se.setId(session_rs.getInt("sesid"));
                            se.setDate(session_rs.getDate("date"));
                            se.setAttended(session_rs.getBoolean("attanded"));
                            se.setRoom(r);
                            se.setT(t);
                            se.setW(w);

                            group.getSessions().add(se);
                        }
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LectureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public ArrayList<Lecture> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
