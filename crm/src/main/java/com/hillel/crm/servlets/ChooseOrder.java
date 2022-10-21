package com.hillel.crm.servlets;

import com.hillel.crm.entity.Order;
import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/chooseorder")
public class ChooseOrder extends BaseServlet {
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
        ResourceBundle rB = getResourceBundle(req);
        Order order = orderServiceForReading.getDetailedOrderByOrderId(orderId);
        String additionalInfo2 = rB.getString("orderdetails.order") + " " + order.getId() + " "
                + rB.getString("orderdetails.dated") + " " + order.getDate();

        req.setAttribute("additionalInfo", rB.getString("orderdetails.top"));
        req.setAttribute("additionalInfo2", additionalInfo2);
        req.setAttribute("detailedOrder", order);
        req.getRequestDispatcher("/jsp/orderdetails.jsp").forward(req, response);
    }
}
