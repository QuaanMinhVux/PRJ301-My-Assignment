/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Week;

/**
 *
 * @author MSI_GF63
 */
public class WeekDBContext extends DBContext<Week> {

    @Override
    public ArrayList<Week> list() {
        ArrayList<Week> res = new ArrayList<>();
        try {
            String sql = "select wid, [week], [from], [to] from Week";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Week w = new Week();
                w.setId(rs.getInt("wid"));
                w.setWeek(rs.getInt("week"));
                w.setFrom(rs.getDate("from"));
                w.setTo(rs.getDate("to"));
                res.add(w);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void insert(Week model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Week model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Week model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public Week get(Date d) {
        Week w = null;
        try {
            String sql = "select wid, [week], [from], [to] from Week where ? between [from] and [to]";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, d);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                w = new Week();
                w.setId(rs.getInt("wid"));
                w.setWeek(rs.getInt("week"));
                w.setFrom(rs.getDate("from"));
                w.setTo(rs.getDate("to"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;
    }

    @Override
    public Week get(int id) {
        Week w = null;
        try {
            String sql = "select wid, [week], [from], [to] from Week where wid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                w = new Week();
                w.setId(rs.getInt("wid"));
                w.setWeek(rs.getInt("week"));
                w.setFrom(rs.getDate("from"));
                w.setTo(rs.getDate("to"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeekDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return w;
    }

}
