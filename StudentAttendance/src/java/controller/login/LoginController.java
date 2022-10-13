/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;

import dal.LectureDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author MSI_GF63
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String role = req.getParameter("role");
        if (id == null || id.equals("")) {
            resp.sendRedirect("index.html");
        } else {
            if (role.equals("student")) {
                StudentDBContext db = new StudentDBContext();
                if (db.checkStudent(Integer.parseInt(id))) {
                    req.setAttribute("id", id);
                    req.setAttribute("role", role);
                    resp.sendRedirect("student/timetable?id=" + id + "&role=" + role);
                } else {
                    resp.sendRedirect("index.html");
                }
            }else{
                LectureDBContext db = new LectureDBContext();
                if(db.checkLecture(id)){
                    req.setAttribute("id", id);
                    req.setAttribute("role", role);
                    resp.sendRedirect("lecture/timetable?id=" + id + "&role=" + role);
                }else {
                    resp.sendRedirect("index.html");
                }
            }
        }

    }

}
