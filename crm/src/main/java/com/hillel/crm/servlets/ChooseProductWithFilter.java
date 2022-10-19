package com.hillel.crm.servlets;

import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/chooseproductwithfilter")
public class ChooseProductWithFilter extends HttpServlet {
    private OrderServiceForReading orderServiceForReading;

    public ChooseProductWithFilter() {
        orderServiceForReading = new OrderServiceForReading();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setAttribute("productList", orderServiceForReading.getAllProducts());
        req.getRequestDispatcher("/jsp/chooseproductwithfilter.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("chooseProduct"));
        String infoString = "Below you can find search results for following filters: "
                + "1) orders were made today, \n"
                + "2) orders mustn't contain product "
                + orderServiceForReading.getProductById(productId).getName();

        req.setAttribute("listOfOrders", orderServiceForReading.getOrdersThatDoNotContainTheProductAndContainCurDate(productId));
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/jsp/listoforders.jsp").forward(req, response);
    }
}
