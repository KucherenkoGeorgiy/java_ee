package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test")
public class ChooseOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        req.setAttribute("testList", orderServiceForReading.getAllOrders());
        req.getRequestDispatcher("/chooseorder.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("chooseOrder"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        req.setAttribute("additionalInfo", "Below you can find all details of chosen order");
        req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
        req.getRequestDispatcher("/orderdetails.jsp").forward(req, response);
    }
}
