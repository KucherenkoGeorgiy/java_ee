package com.hillel.crm.dbutils.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionProvider {

    public static Connection provideConnection() {
        Properties properties = new Properties();

        try (InputStream is = ConnectionProvider.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(is);
        } catch (IOException e) {
            System.err.println("cannot read properties");
            return null;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/schema_orders", properties);
        } catch (SQLException e) {
            System.err.println("cannot get connection");
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
