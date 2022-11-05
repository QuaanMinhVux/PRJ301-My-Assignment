/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecture;

import controller.login.BaseRoleAuthentication;
import dal.GroupDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendance;
import model.Group;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class AttendenceReportController extends BaseRoleAuthentication {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void Post(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void Get(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        processRequest(req, resp);
    }

    void processRequest(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        GroupDBContext db = new GroupDBContext();
        int gid = Integer.parseInt(req.getParameter("id"));
        Group g = db.get(gid);
        for (Student student : g.getStudents()) {
            int absent = getAbsent(student);
            student.setAbsent(absent);
        }
        req.setAttribute("group", g);
        req.getRequestDispatcher("../view/lecture/attreport.jsp").forward(req, resp);
    }

    int getAbsent(Student s) {
        int count = 0;
        for (Attendance a : s.getAtt()) {
            if (a.getSession().isAttended()) {
                if (!a.isPresent()) {
                    count++;
                }
            }
        }
        return count;
    }
}
