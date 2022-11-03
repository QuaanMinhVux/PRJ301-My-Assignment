/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dummy;
import model.User;

/**
 *
 * @author MSI_GF63
 */
public class UserDBContext extends DBContext {

    public User get(String username, String password) {
        User u = null;
        try {
            String sql = "select * from [User] a\n"
                    + "where a.[username] = ? and a.[password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                if(u == null){
                    u = new User();
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                }
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
