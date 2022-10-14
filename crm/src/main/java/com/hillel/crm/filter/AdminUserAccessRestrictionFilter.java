package com.hillel.crm.filter;

import com.hillel.crm.dbutils.entity.User;
import com.hillel.crm.dbutils.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter({"/deleteorders", "/createneworder"})
public class AdminUserAccessRestrictionFilter extends HttpServlet implements Filter {
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
                httpServletRequest.setAttribute("errorInfo",
                        "You don't have rights to do it");
                httpServletRequest.getRequestDispatcher("/jsp/errorhappened.jsp").forward(servletRequest, servletResponse);
            }
        }
    }
}
