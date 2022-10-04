package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForEditing;
import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createneworder")
public class CreateOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getRequestDispatcher("/createneworder.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForEditing orderServiceForEditing = new OrderServiceForEditing();
        int orderId = orderServiceForEditing.addNewOrderWithCurDate();
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        req.setAttribute("additionalInfo", "New order was created.. Details of new order are below");
        req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
        req.getRequestDispatcher("/orderdetails.jsp").forward(req, response);
    }
}
