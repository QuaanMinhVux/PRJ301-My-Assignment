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
import model.Attendance;
import model.Group;
import model.Lecture;
import model.Room;
import model.Session;
import model.Student;
import model.Subject;

/**
 *
 * @author MSI_GF63
 */
public class SessionDBContext extends DBContext<Session> {

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        try {
            connection.setAutoCommit(false);
            String sql_update = "UPDATE [Session]\n"
                    + "   SET [attanded] = 1\n"
                    + " WHERE sesid = ?";
            PreparedStatement stm_update = connection.prepareStatement(sql_update);
            stm_update.setInt(1, model.getId());
            stm_update.executeUpdate();

            String sql_delete = "DELETE [Attandance]\n"
                    + "      WHERE sesid = ?";
            PreparedStatement stm_delete = connection.prepareStatement(sql_delete);
            stm_delete.setInt(1, model.getId());
            stm_delete.executeUpdate();

            String sql_insert = "INSERT INTO [Attandance]\n"
                    + "           ([sesid]\n"
                    + "           ,[stdid]\n"
                    + "           ,[present]\n"
                    + "           ,[description])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm_insert = connection.prepareStatement(sql_insert);
            for (Attendance att : model.getAtt()) {
                stm_insert.setInt(1, model.getId());
                stm_insert.setInt(2, att.getStudent().getId());
                stm_insert.setBoolean(3, att.isPresent());
                stm_insert.setString(4, att.getDescription());
                stm_insert.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(int id) {
        try {
            String sql = "select se.sesid, se.rid, se.[date], se.attanded, g.gid, g.gname, sub.subname, l.lname, r.rname, s.stdid, s.stdname, ISNULL(a.present, 0) present, ISNULL(a.[description], '') [description]\n"
                    + "from [Session] se \n"
                    + "inner join [Group] g on se.gid = g.gid\n"
                    + "inner join [Subject] sub on sub.subid = g.subid\n"
                    + "inner join [Room] r on r.rid = se.rid\n"
                    + "inner join [Lecturer] l on l.lid = g.lid\n"
                    + "inner join [Student_Group] sg on sg.gid = g.gid\n"
                    + "inner join [Student] s on s.stdid = sg.stdid\n"
                    + "left join [Attandance] a on a.sesid = se.sesid and a.stdid = s.stdid\n"
                    + "where se.sesid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Session se = null;
            while (rs.next()) {
                if (se == null) {
                    se = new Session();
                    se.setId(rs.getInt("sesid"));
                    se.setAttended(rs.getBoolean("attanded"));
                    se.setDate(rs.getDate("date"));

                    Room r = new Room();
                    r.setName(rs.getString("rname"));
                    se.setRoom(r);

                    Group g = new Group();
                    g.setId(rs.getInt("gid"));
                    g.setName(rs.getString("gname"));

                    Subject sub = new Subject();
                    sub.setName(rs.getString("subname"));
                    g.setSubject(sub);

                    Lecture l = new Lecture();
                    l.setName(rs.getString("lname"));
                    g.setLecture(l);

                    se.setGroup(g);
                }
                Student s = new Student();
                s.setName(rs.getString("stdname"));
                s.setId(rs.getInt("stdid"));

                Attendance a = new Attendance();
                a.setStudent(s);
                a.setPresent(rs.getBoolean("present"));
                a.setDescription(rs.getString("description"));

                se.getAtt().add(a);
            }
            return se;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Session> list() {
        try {
            ArrayList<Session> list = new ArrayList<>();
            String sql = "select se.sesid, se.gid, se.[date], se.attanded, r.rid, r.rname, t.tid, t.[from], t.[to]\n"
                    + "from [Session] se\n"
                    + "inner join Room r on r.rid = se.rid\n"
                    + "inner join [Week] w on w.wid = se.wid\n"
                    + "inner join TimeSlot t on t.tid = se.tid\n"
                    + "where gid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, 1);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setId(rs.getInt("sesid"));
                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
