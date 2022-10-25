/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author MSI_GF63
 */
public abstract class BaseAuthenticationController extends HttpServlet {

    public boolean isAuthen(HttpServletRequest req) {
        return req.getSession().getAttribute("account") != null;
    }

    public abstract void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public abstract void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isAuthen(req)) {
            processPost(req, resp);
        } else {
            resp.sendRedirect("../index.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isAuthen(req)) {
            processGet(req, resp);
        } else {
            resp.sendRedirect("../index.html");
        }   
    }

}
