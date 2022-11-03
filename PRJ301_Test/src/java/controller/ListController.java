/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DummyDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Dummy;
import model.User;

/**
 *
 * @author MSI_GF63
 */
public class ListController extends BaseAuthenticationController{

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DummyDBContext db = new DummyDBContext();
        User u = (User)req.getSession().getAttribute("user");
        ArrayList<Dummy> d = db.get(u.getUsername());
        req.getSession().setAttribute("dummy", d);
        req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
    }
    
}
