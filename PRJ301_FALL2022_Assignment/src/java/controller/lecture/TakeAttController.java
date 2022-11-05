/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecture;

import controller.login.BaseRoleAuthentication;
import dal.SessionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendance;
import model.Session;
import util.DateTimeHelper;

/**
 *
 * @author MSI_GF63
 */
public class TakeAttController extends BaseRoleAuthentication {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void Post(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        Session s = (Session) req.getSession().getAttribute("session");
        if (DateTimeHelper.isDay(s.getDate())) {
            for (Attendance att : s.getAtt()) {
                att.setPresent(req.getParameter("present" + att.getStudent().getId()).equals("present"));
                att.setDescription(req.getParameter("comment" + att.getStudent().getId()));
            }
            req.getSession().removeAttribute("session");
            SessionDBContext db = new SessionDBContext();
            db.update(s);
            resp.sendRedirect("takeatt?id=" + s.getId());
        } else {
            resp.getWriter().println("Access denied");

        }

    }

    @Override
    public void Get(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException, IOException {
        int seid = Integer.parseInt(req.getParameter("id"));
        SessionDBContext sdb = new SessionDBContext();
        Session session = sdb.get(seid);
        req.getSession().setAttribute("session", session);
        req.getRequestDispatcher("../view/lecture/takeatt.jsp").forward(req, resp);
    }
}
