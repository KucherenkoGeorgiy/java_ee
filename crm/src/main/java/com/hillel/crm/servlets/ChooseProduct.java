package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/chooseproduct")
public class ChooseProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        response.setContentType("text/html");

        req.setAttribute("productList", orderServiceForReading.getAllProducts());

        req.getRequestDispatcher("/chooseproduct.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("chooseProduct"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        String infoString = "Below you can find search results for following filters:\n"
                + " must contain product: "
                + orderServiceForReading.getAllProducts().stream()
                .filter(a -> a.getId() == productId).toList().get(0).getName();

        response.setContentType("text/html");

        req.setAttribute("listOfOrders", orderServiceForReading.getOrdersThatContainTheProduct(productId));
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/listoforders.jsp").forward(req, response);
    }
}
