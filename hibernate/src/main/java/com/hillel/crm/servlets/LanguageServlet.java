package com.hillel.crm.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.jstl.core.Config;

import java.io.IOException;

@WebServlet("/language")
public class LanguageServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String localeToSet = req.getParameter("locale");
        HttpSession session = req.getSession();

        Config.set(session, "jakarta.servlet.jsp.jstl.fmt.locale", localeToSet);
        resp.sendRedirect("/crm");
    }
}
