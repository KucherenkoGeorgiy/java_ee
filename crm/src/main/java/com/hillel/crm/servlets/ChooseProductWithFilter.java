package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/chooseproductwithfilter")
public class ChooseProductWithFilter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();

        req.setAttribute("productList", orderServiceForReading.getAllProducts());
        req.getRequestDispatcher("/chooseproductwithfilter.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("chooseProduct"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        String infoString = "Below you can find search results for following filters: "
                + "1) orders were made today, \n"
                + "2) orders mustn't contain product "
                + orderServiceForReading.getProductById(productId).getName();

        req.setAttribute("listOfOrders", orderServiceForReading.getOrdersThatDoNotContainTheProductAndContainCurDate(productId));
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/listoforders.jsp").forward(req, response);
    }
}
