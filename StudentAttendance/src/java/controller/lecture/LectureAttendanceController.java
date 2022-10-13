/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecture;

import dal.GroupDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Group;

/**
 *
 * @author MSI_GF63
 */
public class LectureAttendanceController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        ArrayList<Group> group = new GroupDBContext().getList(id);
        StudentDBContext db = new StudentDBContext();
        db.getStudent(0);
        req.setAttribute("id", id);
        req.setAttribute("group", group);
        req.getRequestDispatcher("../view/lecture/attendance.jsp").forward(req, resp);
    }
}
