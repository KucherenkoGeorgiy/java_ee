package com.hillel.crm.dbutils.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionProvider {

    public static Connection provideConnection() {
        Properties properties = new Properties();

//        try (FileInputStream inStream = new FileInputStream("db.properties")) {
//            properties.load(inStream);
//        } catch (IOException e) {
//            System.err.println("cannot read properties");
//            return null;
//        }
//
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_orders", "root", "Kucherenko2022!");
        } catch (SQLException e) {
            System.err.println("cannot get connection");
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
/*
        try {
            String url = "jdbc:mysql://localhost/schema_orders?serverTimezone=Europe/Kiev&useSSL=false";
            String username = "root";
            String password = "Kucherenko2022!";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                return conn;
            }
        } catch (Exception ex) {
            System.err.println("cannot get connection");
            return null;
        }
*/



  /*      try {
            String url = "jdbc:mysql://localhost/schema_orders?serverTimezone=Europe/Kiev&useSSL=false";
            String username = "root";
            String password = "Kucherenko2022!";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                 return conn;
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
            }
        } catch (Exception ex) {
            System.err.println("Connection failed...");
            return null;

        }

*/

    }
}
