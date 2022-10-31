package com.hillel.crm.servlets;

import com.hillel.crm.entity.Order;
import com.hillel.crm.service.OrderServiceForEditing;
import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet("/deleteorders")
public class DeleteOrders extends BaseServlet {
    private OrderServiceForReading orderServiceForReading;
    private OrderServiceForEditing orderServiceForEditing;

    public DeleteOrders() {
        orderServiceForReading = new OrderServiceForReading();
        orderServiceForEditing = new OrderServiceForEditing();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setAttribute("productList", orderServiceForReading.getAllProducts());
        req.getRequestDispatcher("/jsp/deletewithfilter.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ResourceBundle rB = getResourceBundle(req);

        try {
            int productId = Integer.parseInt(req.getParameter("chooseProduct"));
            int orderQuantity = Integer.parseInt(req.getParameter("chooseQuantity"));
            List<Order> deletedOrders = orderServiceForEditing
                    .deleteOrdersThatContainTheProductWithQuantity(productId, orderQuantity);
            String infoString = rB.getString("deletewithfilter.result1")
                    + orderServiceForReading.getProductById(productId).getName()
                    + rB.getString("deletewithfilter.result2") + " " + orderQuantity;

            if (deletedOrders.size() != 0) {
                infoString += rB.getString("deletewithfilter.resultfinal");
            } else {
                infoString += rB.getString("deletewithfilter.resultnothing");
            }

            req.setAttribute("listOfOrders", deletedOrders);
            req.setAttribute("filtersOfSearch", infoString);
            req.getRequestDispatcher("/jsp/listoforders.jsp").forward(req, response);
        } catch (NumberFormatException e) {
            req.setAttribute("errorInfo", rB.getString("error.deleteorder"));
            req.getRequestDispatcher("/jsp/errorhappened.jsp").forward(req, response);
        }
    }
}
