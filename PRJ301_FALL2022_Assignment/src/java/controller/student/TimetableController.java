/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.student;

import dal.StudentDBContext;
import dal.WeekDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;
import model.Student;
import model.Week;
import util.DateTimeHelper;

/**
 *
 * @author MSI_GF63
 */
public class TimetableController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        processRequest(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String w = req.getParameter("week");
//        DateTimeHelper dth = new DateTimeHelper();
//        WeekDBContext wdb = new WeekDBContext();
//        ArrayList<Week> week = wdb.list();
//        Week now = new Week();
//        if (w == null) {
//            now = wdb.get(Date.valueOf(LocalDate.now()));
//        } else {
//            now = wdb.get(Integer.parseInt(w));
//        }
//        StudentDBContext sdb = new StudentDBContext();
//        Student s = sdb.get(id);
//        ArrayList<Date> day = dth.getDate(now.getFrom(), now.getTo());
//        req.setAttribute("student", s);
//        req.setAttribute("day", day);
//        req.setAttribute("student", s);
//        req.setAttribute("now", now.getWeek());
//        req.setAttribute("week", week);
//        req.getRequestDispatcher("../view/student/timetable.jsp").forward(req, resp);
            resp.getWriter().print(req.getSession().getAttribute("account"));
    }
}