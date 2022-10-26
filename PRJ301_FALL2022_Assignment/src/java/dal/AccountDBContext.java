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
import model.Feature;
import model.Role;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class AccountDBContext extends DBContext<Account> {

    public Account get(String username, String password) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select a.username, a.displayname, r.rid, r.rname, f.fid, f.fname, f.url\n"
                    + "from [Account] a left join [Role] r on r.rid = a.rid\n"
                    + "left join [Role_Feature] rf on rf.rid = r.rid\n"
                    + "left join [Feature] f on f.fid = rf.fid\n"
                    + "where a.username = ? and a.password = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            Account acc = null;
            Role currentRole = new Role();
            currentRole.setRid(-1);
            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    acc.setUsername(rs.getString("username"));
                    acc.setDisplayname(rs.getString("displayname"));
                    Role r = new Role();
                    r.setRid(rs.getInt("rid"));
                    r.setRname(rs.getString("rname"));
                    acc.setRole(r);
                }
                int fid = rs.getInt("fid");
                if (fid != 0) {
                    Feature f = new Feature();
                    f.setFid(rs.getInt("fid"));
                    f.setFname(rs.getString("fname"));
                    f.setUrl(rs.getString("url"));
                    acc.getRole().getFeature().add(f);
                }
                if (acc.getRole().getRid() == 1) {
                    String student_sql = "select s.stdid, s.stdname, s.username from Student s inner join [Account] a on s.username = a.username\n"
                            + "left join [Role] r on r.rid = a.rid \n"
                            + "where r.rid = 1 and a.username = ?";
                    PreparedStatement student_stm = connection.prepareStatement(student_sql);
                    student_stm.setString(1, username);
                    ResultSet student_rs = student_stm.executeQuery();
                    if(student_rs.next()){
                        Student s = new Student();
                        s.setId(student_rs.getInt("stdid"));
                        s.setName(student_rs.getString("stdname"));
                        acc.setStudent(s);
                    }
                }
            }
           
            return acc;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (stm != null)
                try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connection != null)
                try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
