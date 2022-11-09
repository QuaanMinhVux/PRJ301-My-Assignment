/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.student;

import controller.login.BaseAuthenticationController;
import controller.login.BaseRoleAuthentication;
import dal.SessionDBContext;
import dal.StudentDBContext;
import dal.TimeslotDBContext;
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
import model.Account;
import model.Session;
import model.Student;
import model.Time_Slot;
import model.Week;
import util.DateTimeHelper;

/**
 *
 * @author MSI_GF63
 */
public class TimetableController extends BaseRoleAuthentication {

    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("account");
        String w = req.getParameter("week");
        WeekDBContext wdb = new WeekDBContext();
        ArrayList<Week> week = wdb.list();
        Week now = new Week();
        if (w == null) {
            now = wdb.get(Date.valueOf(LocalDate.now()));
        } else {
            now = wdb.get(Integer.parseInt(w));
        }
        StudentDBContext sdb = new StudentDBContext();
        Student s = sdb.get(acc.getStudent().getId());
        ArrayList<Date> day = DateTimeHelper.getDateList(now.getFrom(), now.getTo());
        TimeslotDBContext tdb = new TimeslotDBContext();
        ArrayList<Time_Slot> ts = tdb.list();
        req.setAttribute("slot", ts);
        req.setAttribute("student", s);
        req.setAttribute("day", day);
        req.setAttribute("now", now.getWeek());
        req.setAttribute("week", week);
        req.getRequestDispatcher("../view/student/timetable.jsp").forward(req, resp);
    }

    @Override
    public void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
