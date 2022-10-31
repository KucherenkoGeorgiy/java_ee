package com.hillel.crm.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.jstl.core.Config;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseServlet extends HttpServlet {

    protected ResourceBundle getResourceBundle(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (Config.get(session, "jakarta.servlet.jsp.jstl.fmt.locale") != null) {
            String[] tab = ((String) Config.get(session, "jakarta.servlet.jsp.jstl.fmt.locale")).split("_");
            return ResourceBundle.getBundle("messages", new Locale(tab[0], tab[1]));
        } else {
            return ResourceBundle.getBundle("messages", req.getLocale());
        }
    }
}
