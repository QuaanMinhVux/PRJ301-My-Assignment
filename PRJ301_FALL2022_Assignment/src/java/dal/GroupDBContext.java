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
import model.Account;
import model.Attendance;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Subject;
import model.Time_Slot;

/**
 *
 * @author MSI_GF63
 */
public class GroupDBContext extends DBContext<Group> {

    public Group get(int id, Account acc) {
        try {
            String sql = "select g.gid, g.gname, su.subname, su.subslot, l.lid, l.lname, r.rname, ts.[from], ts.[to], ss.[date], ss.attanded, a.present, a.[description]  from [Group] g \n"
                    + "inner join [Student_Group] sg on g.gid = sg.gid\n"
                    + "inner join [Student] s on s.stdid = sg.stdid\n"
                    + "inner join [Session] ss on ss.gid = g.gid\n"
                    + "inner join [Subject] su on su.subid = g.subid\n"
                    + "inner join [TimeSlot] ts on ts.tid = ss.tid\n"
                    + "inner join [Room] r on r.rid = ss.rid\n"
                    + "inner join [Lecturer] l on l.lid = g.lid\n"
                    + "left join [Attandance] a on a.sesid = ss.sesid and s.stdid = a.stdid\n"
                    + "where s.stdid = ? and g.gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(2, id);
            stm.setInt(1, acc.getStudent().getId());
            ResultSet rs = stm.executeQuery();
            Group g = null;
            while (rs.next()) {
                if (g == null) {
                    g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));

                    Subject su = new Subject();
                    su.setName(rs.getString("subname"));
                    su.setSlot(rs.getInt("subslot"));
                    g.setSubject(su);

                    Lecture l = new Lecture();
                    l.setId(rs.getInt("lid"));
                    l.setName(rs.getString("lname"));
                    g.setLecture(l);
                }
                Session se = new Session();
                se.setDate(rs.getDate("date"));
                se.setAttended(rs.getBoolean("attanded"));

                Room r = new Room();
                r.setName(rs.getString("rname"));
                se.setRoom(r);
                
                Time_Slot ts = new Time_Slot();
                ts.setFrom(rs.getTime("from"));
                ts.setTo(rs.getTime("to"));
                se.setT(ts);
                
                Attendance att = new Attendance();
                att.setPresent(rs.getBoolean("present"));
                att.setDescription(rs.getString("description"));
                se.getAtt().add(att);
                
                g.getSessions().add(se);
            }
            return g;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Group model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Group get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Group> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
