/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import model.Feature;

/**
 *
 * @author MSI_GF63
 */
public abstract class BaseRoleAuthentication extends BaseAuthenticationController {

    private boolean checkRole(HttpServletRequest req) {
        Account acc = (Account) req.getSession().getAttribute("account");
        String currentUrl = req.getServletPath();
        for (Feature feature : acc.getRole().getFeature()) {
            if (feature.getUrl().equals(currentUrl)) {
                return true;
            }
        }
        return false;
    }

    public abstract void Post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public abstract void Get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkRole(req)) {
            Post(req, resp);
        } else {
            resp.getWriter().println("Access denied");
        }
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkRole(req)) {
            Get(req, resp);
        } else {
            resp.getWriter().println("Access denied");
        }
    }

}
