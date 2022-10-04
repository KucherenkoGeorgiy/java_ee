package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/finderbysumandquantity")
public class FinderBySumAndQuantity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getRequestDispatcher("/finderbysumamountandquantity.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        int orderSum = Integer.parseInt(req.getParameter("chooseSum"));
        int orderQuantity = Integer.parseInt(req.getParameter("chooseQuantity"));
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        String infoString = "Below you can find search results for following filters:\n"
                + " total amount of order is: " + orderSum
                + " quantity of products is: " + orderQuantity;

        req.setAttribute("listOfOrders", orderServiceForReading.getByTotMaxAndQuantityOfDifGoods(orderSum, orderQuantity));
        req.setAttribute("filtersOfSearch", infoString);
        req.getRequestDispatcher("/listoforders.jsp").forward(req, response);
    }
}
