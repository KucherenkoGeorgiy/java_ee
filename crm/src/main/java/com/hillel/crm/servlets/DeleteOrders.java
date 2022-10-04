package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.service.OrderServiceForEditing;
import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/deleteorders")
public class DeleteOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        req.setAttribute("productList", orderServiceForReading.getAllProducts());
        req.getRequestDispatcher("/deletewithfilter.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("chooseProduct"));
        int orderQuantity = Integer.parseInt(req.getParameter("chooseQuantity"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        OrderServiceForEditing orderServiceForEditing = new OrderServiceForEditing();
        List<Order> deletedOrders = orderServiceForEditing
                .deleteOrdersThatContainTheProductWithQuantity(productId, orderQuantity);
        String infoString;

        if (deletedOrders.size() != 0) {
            infoString = "Below you can find list of orders that were deleted\n"
                    + " Filter for deleting is: 1) product name - "
                    + orderServiceForReading.getAllProducts().stream()
                    .filter(a -> a.getId() == productId).toList().get(0).getName()
                    + ", 2) product quantity - " + orderQuantity + ".";
        } else {
            infoString = "You have chosen following filters for deleting: 1) product name - "
                    + orderServiceForReading.getAllProducts().stream()
                    .filter(a -> a.getId() == productId).toList().get(0).getName()
                    + ", 2) product quantity - " + orderQuantity + ". And there were NOTHING TO DELETE!";
        }

        req.setAttribute("listOfOrders", deletedOrders);
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/listoforders.jsp").forward(req, response);
    }
}
