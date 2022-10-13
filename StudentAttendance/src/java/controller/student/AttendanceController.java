/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.student;

import dal.GroupDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Group;
import model.Session;
import model.Student;

/**
 *
 * @author MSI_GF63
 */
public class AttendanceController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int group_id = 0;
        String raw_group_id = req.getParameter("subject");
        if(raw_group_id != null && !raw_group_id.equals("")){
            group_id = Integer.parseInt(raw_group_id);
        }
        StudentDBContext sdb = new StudentDBContext();
        SessionDBContext ssdb = new SessionDBContext();
        ArrayList<Session> session = ssdb.getListByGroup(group_id);
        GroupDBContext gdb = new GroupDBContext();
        ArrayList<Group> group = gdb.getList(id);
        Student student = sdb.getStudentByID(id);
       // int absent = ssdb.Absent(session);
      //  req.setAttribute("absent", absent);
        req.setAttribute("student", student);
        req.setAttribute("session", session);
        req.setAttribute("group", group);
        req.getRequestDispatcher("../view/student/attendance.jsp").forward(req, resp);
    }
    
}
