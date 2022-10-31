package com.hillel.crm.modifier;

import com.hillel.crm.connection.SessionFactoryHolder;
import com.hillel.crm.entity.Order;
import com.hillel.crm.entity.RecordsOfOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Modifier {

    public int createNewOrder(List<RecordsOfOrder> recOfOrdReady) {
        int finalID;

        if (!recOfOrdReady.isEmpty()) {
            Order order = new Order();
            order.setDate(Date.valueOf(LocalDate.now()));
            order.setRecordsOfOrder(recOfOrdReady);
            Session session = SessionFactoryHolder.provideSession();
            Transaction transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
            finalID = order.getId();
            session.close();
            return finalID;
        } else {
            return -1;
        }
    }

    public void deleteAllOrders(List<Order> orders) {
        Session session = SessionFactoryHolder.provideSession();
        Transaction transaction = session.beginTransaction();
        orders.forEach(session::remove);
        transaction.commit();
        session.close();
    }
}
