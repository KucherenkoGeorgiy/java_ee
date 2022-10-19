package com.hillel.crm.servlets;

import com.hillel.crm.service.OrderServiceForEditing;
import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createneworder")
public class CreateOrder extends HttpServlet {
    private OrderServiceForReading orderServiceForReading;
    private OrderServiceForEditing orderServiceForEditing;

    public CreateOrder() {
        orderServiceForReading = new OrderServiceForReading();
        orderServiceForEditing = new OrderServiceForEditing();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/createneworder.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int orderId = orderServiceForEditing.addNewOrderWithCurDate();

        try {
            req.setAttribute("additionalInfo", "New order was created.. Details of new order are below");
            req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
            req.getRequestDispatcher("/jsp/orderdetails.jsp").forward(req, response);
        } catch (NullPointerException e) {
            req.setAttribute("errorInfo", "Could not create order. Because there are no orders today");
            req.getRequestDispatcher("/jsp/errorhappened.jsp").forward(req, response);
        }
    }
}
