package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/chooseorder")
public class ChooseOrder extends HttpServlet {
    private OrderServiceForReading orderServiceForReading;

    public ChooseOrder() {
        orderServiceForReading = new OrderServiceForReading();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setAttribute("testList", orderServiceForReading.getAllOrders());
        req.getRequestDispatcher("/jsp/chooseorder.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("chooseOrder"));

        req.setAttribute("additionalInfo", "Below you can find all details of chosen order");
        req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
        req.getRequestDispatcher("/jsp/orderdetails.jsp").forward(req, response);
    }
}
