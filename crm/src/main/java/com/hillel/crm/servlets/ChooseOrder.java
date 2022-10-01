package com.hillel.crm.servlets;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.service.OrderServiceForReading;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebServlet("/test")
public class ChooseOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        OrderServiceForReading orderServiceForReading = new OrderServiceForReading();
        response.setContentType("text/html");

        req.setAttribute("testList", orderServiceForReading.getAllOrders());

        req.getRequestDispatcher("/chooseorder.jsp").forward(req, response);

//        response.getOutputStream().println(orderServiceForReading.getDetailedOrderByOrderId(1).toString());
        // C:\01 - Java\Java EE\crm\target\crm\WEB-INF\classes


//        Properties properties = new Properties();
//
//        try (FileInputStream inStream = new FileInputStream("db.properties")) {
//            properties.load(inStream);
//        } catch (IOException e) {
//            System.err.println("cannot read properties");
//                    resp.getOutputStream().println("cannot read properties");
//
//        }
//        resp.getOutputStream().println(properties.toString());

//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_orders", "root", "Kucherenko2022!");
//        } catch (SQLException e) {
//                                resp.getOutputStream().println(Arrays.toString(e.getStackTrace()));
//
//        } finally {
//            resp.getOutputStream().println("connection was made");
//        }
//        resp.getOutputStream().println("connection was made");
//

//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        try {
//            String url = "jdbc:mysql://localhost/schema_orders?serverTimezone=Europe/Kiev&useSSL=false";
//            String username = "root";
//            String password = "Kucherenko2022!";
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                writer.println("Connection to ProductDB succesfull!");
//
//                try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM schema_orders.orders;")) {
//                    ResultSet resultSet = statement.executeQuery();
////                    List<Order> result = new ArrayList<>();
//                    while (resultSet.next()) {
////                        result.add(entityExtractor.extract(resultSet));
//                        writer.println(resultSet.getInt("id"));
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } finally {
//                    conn.close();
//                }
//            }
//        } catch (Exception ex) {
//            writer.println("Connection failed...");
//            writer.println(ex);
//        } finally {
//            writer.close();
//        }

    }
}
