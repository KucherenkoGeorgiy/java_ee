package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebServlet("/test")
public class ChooseOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        response.setContentType("text/html");

        req.setAttribute("testList", orderServiceForReading.getAllOrders());

        req.getRequestDispatcher("/chooseorder.jsp").forward(req, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("chooseOrder"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        response.setContentType("text/html");

        req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
        req.getRequestDispatcher("/orderdetails.jsp").forward(req, response);
    }
}
