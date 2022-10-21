package com.hillel.crm.servlets;

import com.hillel.crm.entity.User;
import com.hillel.crm.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    private UserService userService;

    public LoginServlet() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Optional<User> found = userService.findByNameAndPassword(name, password);
        ResourceBundle rB = getResourceBundle(req);

        if (found.isEmpty()) {
            req.setAttribute("errorMessage", rB.getString("login.error"));
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", found.get());
            resp.sendRedirect("/crm");
        }
    }
}
