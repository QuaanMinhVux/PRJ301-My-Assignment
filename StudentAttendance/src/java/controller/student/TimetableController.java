/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.student;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
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
import model.Attendance;
import model.Session;
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
        String raw_id = req.getParameter("id");
        String role = req.getParameter("role");
        String raw_year = req.getParameter("year");
        String raw_week = req.getParameter("week");
        String flag = req.getParameter("flag");
        if (flag == null || flag.equals("")) {
            int id = Integer.parseInt(raw_id);
            java.util.Date date = new java.util.Date();
            int year = date.getYear() + 1900;
            WeekDBContext db = new WeekDBContext();
            ArrayList<Week> week = db.getList();
            LocalDate now = LocalDate.now();
            int weeknow = now.get(WeekFields.of(Locale.getDefault()).weekOfYear());
            Week w = db.getWeek(weeknow);
            DateTimeHelper dt = new DateTimeHelper();
            ArrayList<Date> list = dt.getDate(w.getFrom(), w.getTo());
            SessionDBContext sdb = new SessionDBContext();
            ArrayList<Session> ss = sdb.getList(id);
            StudentDBContext studb = new StudentDBContext();
            Student s = studb.getStudentByID(id);
            AttendanceDBContext adb = new AttendanceDBContext();
            ArrayList<Attendance> a = adb.getAttendance(id);
            req.setAttribute("attendance", a);
            req.setAttribute("session", ss);
            req.setAttribute("now", weeknow);
            req.setAttribute("week", week);
            req.setAttribute("student", s);
            req.setAttribute("role", role);
            req.setAttribute("day", list);
        } else {
            int id = Integer.parseInt(raw_id);
            int year = Integer.parseInt(raw_year);
            int now = Integer.parseInt(raw_week);
            WeekDBContext db = new WeekDBContext();
            DateTimeHelper dt = new DateTimeHelper();
            Week w = db.getWeek(now);
            ArrayList<Date> list = dt.getDate(w.getFrom(), w.getTo());
            ArrayList<Week> week = db.getList();
            SessionDBContext sdb = new SessionDBContext();
            ArrayList<Session> ss = sdb.getList(id);
            StudentDBContext studb = new StudentDBContext();
            Student s = studb.getStudentByID(id);
            AttendanceDBContext adb = new AttendanceDBContext();
            ArrayList<Attendance> a = adb.getAttendance(id);
            req.setAttribute("attendance", a);
            req.setAttribute("session", ss);
            req.setAttribute("student", s);
            req.setAttribute("role", role);
            req.setAttribute("now", now);
            req.setAttribute("week", week);
            req.setAttribute("day", list);
        }

        req.getRequestDispatcher("../view/student/timetable.jsp").forward(req, resp);
    }

}
