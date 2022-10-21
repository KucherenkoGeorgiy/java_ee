package com.hillel.crm.servlets;

import com.hillel.crm.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/finderbysumandquantity")
public class FinderBySumAndQuantity extends BaseServlet {
    private OrderServiceForReading orderServiceForReading;

    public FinderBySumAndQuantity() {
        orderServiceForReading = new OrderServiceForReading();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/finderbysumamountandquantity.jsp").forward(req, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ResourceBundle rB = getResourceBundle(req);

        try {
            int orderSum = Integer.parseInt(req.getParameter("chooseSum"));
            int orderQuantity = Integer.parseInt(req.getParameter("chooseQuantity"));
            String infoString = rB.getString("listoforders.top1") + "\n "
                    + rB.getString("listoforders.top2") + " " + orderSum + " "
                    + rB.getString("listoforders.top3") + orderQuantity;

            req.setAttribute("listOfOrders", orderServiceForReading.getByTotMaxAndQuantityOfDifGoods(orderSum, orderQuantity));
            req.setAttribute("filtersOfSearch", infoString);
            req.getRequestDispatcher("/jsp/listoforders.jsp").forward(req, response);
        } catch (NumberFormatException e) {
            req.setAttribute("errorInfo", rB.getString("listoforders.error"));
            req.getRequestDispatcher("/jsp/errorhappened.jsp").forward(req, response);
        }
    }
}
