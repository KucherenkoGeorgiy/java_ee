package com.hillel.crm.servlets;

import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/chooseproduct")
public class ChooseProduct extends BaseServlet {
    private OrderServiceForReading orderServiceForReading;

    public ChooseProduct() {
        orderServiceForReading = new OrderServiceForReading();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setAttribute("productList", orderServiceForReading.getAllProducts());
        req.getRequestDispatcher("/jsp/chooseproduct.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("chooseProduct"));
        ResourceBundle rB = getResourceBundle(req);
        String infoString = rB.getString("chooseproduct.result") + " "
                + orderServiceForReading.getProductById(productId).getName();

        req.setAttribute("listOfOrders", orderServiceForReading.getOrdersThatContainTheProduct(productId));
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/jsp/listoforders.jsp").forward(req, response);
    }
}
