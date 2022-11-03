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
import model.Dummy;

/**
 *
 * @author MSI_GF63
 */
public class DummyDBContext extends DBContext{
    public ArrayList<Dummy> get (String user){
        ArrayList<Dummy> res = new ArrayList<>();
        try {
            String sql = "select * from Dummy where username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Dummy d = new Dummy();
                d.setDname(rs.getString("dname"));
                d.setDid(rs.getInt("did"));
                res.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DummyDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
