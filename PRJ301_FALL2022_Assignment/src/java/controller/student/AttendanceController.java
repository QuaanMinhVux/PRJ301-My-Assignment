/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.student;

import controller.login.BaseRoleAuthentication;
import dal.GroupDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import model.Group;
import model.Session;

/**
 *
 * @author MSI_GF63
 */
public class AttendanceController extends BaseRoleAuthentication {

    @Override
    public void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int gid = Integer.parseInt(req.getParameter("id"));
        Account acc = (Account) req.getSession().getAttribute("account");
        GroupDBContext gdb = new GroupDBContext();
        Group g = gdb.get(gid, acc);
        int absent = getAbsent(g);
        req.setAttribute("absent", absent);
        req.setAttribute("group", g);
        req.getRequestDispatcher("../view/student/att.jsp").forward(req, resp);
        
    }
    int getAbsent(Group g){
        int count = 0;
        for (Session session : g.getSessions()) {
            if(!session.getAtt().get(0).isPresent() && session.isAttended()){
                count ++;
            }
        }
        return count;
    }
}
