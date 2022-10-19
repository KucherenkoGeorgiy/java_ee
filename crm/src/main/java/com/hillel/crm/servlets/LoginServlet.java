package com.hillel.crm.servlets;

import com.hillel.crm.entity.User;
import com.hillel.crm.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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

        if (found.isEmpty()) {
            req.setAttribute("errorMessage", "Incorrect login or password");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", found.get());
            resp.sendRedirect("/crm");
        }
    }
}
