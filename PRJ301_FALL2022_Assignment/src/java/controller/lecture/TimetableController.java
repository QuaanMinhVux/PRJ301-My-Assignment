/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecture;

import controller.login.BaseRoleAuthentication;
import dal.LectureDBContext;
import dal.StudentDBContext;
import dal.WeekDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Account;
import model.Lecture;
import model.Student;
import model.Week;
import util.DateTimeHelper;

/**
 *
 * @author MSI_GF63
 */
public class TimetableController extends BaseRoleAuthentication{

    @Override
    public void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("account");
        String w = req.getParameter("week");
        DateTimeHelper dth = new DateTimeHelper();
        WeekDBContext wdb = new WeekDBContext();
        ArrayList<Week> week = wdb.list();
        Week now = new Week();
        if (w == null) {
            now = wdb.get(Date.valueOf(LocalDate.now()));
        } else {
            now = wdb.get(Integer.parseInt(w));
        }
        LectureDBContext ldb = new LectureDBContext();
        Lecture l = ldb.get(acc.getLecture().getId());
        ArrayList<Date> day = dth.getDate(now.getFrom(), now.getTo());
        req.setAttribute("lecture", l);
        req.setAttribute("day", day);
        req.setAttribute("now", now.getWeek());
        req.setAttribute("week", week);
        req.getRequestDispatcher("../view/lecture/timetable.jsp").forward(req, resp);
    }
    
}
