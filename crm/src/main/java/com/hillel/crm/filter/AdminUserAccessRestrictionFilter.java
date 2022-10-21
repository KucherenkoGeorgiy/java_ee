package com.hillel.crm.filter;

import com.hillel.crm.entity.User;
import com.hillel.crm.entity.UserRole;
import com.hillel.crm.servlets.BaseServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebFilter({"/deleteorders", "/createneworder"})
public class AdminUserAccessRestrictionFilter extends BaseServlet implements Filter {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (METHOD_GET.equals(httpServletRequest.getMethod())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (METHOD_POST.equals(httpServletRequest.getMethod())) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user != null && UserRole.ADMIN == user.getUserRole()) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ResourceBundle rB = getResourceBundle(httpServletRequest);
                httpServletRequest.setAttribute("errorInfo",
                        rB.getString("filter.error"));
                httpServletRequest.getRequestDispatcher("/jsp/errorhappened.jsp").forward(servletRequest, servletResponse);
            }
        }
    }
}
