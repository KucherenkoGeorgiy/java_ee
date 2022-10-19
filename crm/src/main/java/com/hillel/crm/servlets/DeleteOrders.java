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

@WebServlet("/deleteorders")
public class DeleteOrders extends HttpServlet {
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
        try {
            int productId = Integer.parseInt(req.getParameter("chooseProduct"));
            int orderQuantity = Integer.parseInt(req.getParameter("chooseQuantity"));
            List<Order> deletedOrders = orderServiceForEditing
                    .deleteOrdersThatContainTheProductWithQuantity(productId, orderQuantity);
            String infoString = "You have chosen following filters for deleting: 1) product name - "
                    + orderServiceForReading.getProductById(productId).getName()
                    + ", 2) product quantity - " + orderQuantity;

            if (deletedOrders.size() != 0) {
                infoString += ". Below you can find list of orders that were deleted\n";
            } else {
                infoString += ". And there were NOTHING TO DELETE!";
            }

            req.setAttribute("listOfOrders", deletedOrders);
            req.setAttribute("filtersOfSearch", infoString);
            req.getRequestDispatcher("/jsp/listoforders.jsp").forward(req, response);
        } catch (NumberFormatException e) {
            req.setAttribute("errorInfo", "You have entered incorrect data. You had to enter to Integer");
            req.getRequestDispatcher("/jsp/errorhappened.jsp").forward(req, response);
        }
    }
}
