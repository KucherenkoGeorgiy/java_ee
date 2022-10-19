package com.hillel.crm.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectionProvider {

    public static Connection provideConnection() {
        try {
            Context envContext = (Context) new InitialContext().lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/schema_orders");
            return ds.getConnection();
        } catch (SQLException | NamingException e) {
            System.err.println("Cannot get connection");
            return null;
        }
    }
}
