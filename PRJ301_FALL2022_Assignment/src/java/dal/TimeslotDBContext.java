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
import model.Time_Slot;

/**
 *
 * @author MSI_GF63
 */
public class TimeslotDBContext extends DBContext<Time_Slot> {

    @Override
    public void insert(Time_Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Time_Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Time_Slot model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Time_Slot get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Time_Slot> list() {
        try {
            String sql = "select * from TimeSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            ArrayList<Time_Slot> ts = new ArrayList<>();
            while (rs.next()) {
                Time_Slot t = new Time_Slot();
                t.setId(rs.getInt("tid"));
                t.setFrom(rs.getTime("from"));
                t.setTo(rs.getTime("to"));
                ts.add(t);
            }
            return ts;
        } catch (SQLException ex) {
            Logger.getLogger(TimeslotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
