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
import model.Session;

/**
 *
 * @author MSI_GF63
 */
public class SessionDBContext extends DBContext<Session>{

    @Override
    public void insert(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            while(rs.next()){
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
