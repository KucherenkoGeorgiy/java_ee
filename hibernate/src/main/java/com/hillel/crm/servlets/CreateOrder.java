package com.hillel.crm.servlets;

import com.hillel.crm.service.OrderServiceForEditing;
import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/createneworder")
public class CreateOrder extends BaseServlet {
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
        ResourceBundle rB = getResourceBundle(req);

        try {
            req.setAttribute("additionalInfo", rB.getString("createneworder.created"));
            req.setAttribute("detailedOrder", orderServiceForReading.getDetailedOrderByOrderId(orderId));
            req.getRequestDispatcher("/jsp/orderdetails.jsp").forward(req, response);
        } catch (NullPointerException e) {
            req.setAttribute("errorInfo", rB.getString("error.cannotcreateorder"));
            req.getRequestDispatcher("/jsp/errorhappened.jsp").forward(req, response);
        }
    }
}
