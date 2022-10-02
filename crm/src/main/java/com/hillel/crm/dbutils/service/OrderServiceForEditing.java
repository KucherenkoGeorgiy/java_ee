package com.hillel.crm.dbutils.service;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.entity.RecordsOfOrder;
import com.hillel.crm.dbutils.modifier.Modifier;
import com.hillel.crm.dbutils.repository.OrdersRepository;
import com.hillel.crm.dbutils.repository.RecordsOfOrderRepository;

import java.util.List;

public class OrderServiceForEditing {
    OrdersRepository ordersRepository;
    RecordsOfOrderRepository recordsOfOrderRepository;
    Modifier modifier;


    public OrderServiceForEditing() {
        ordersRepository = new OrdersRepository();
        recordsOfOrderRepository = new RecordsOfOrderRepository();
        modifier = new Modifier();
    }

    public List<RecordsOfOrder> getAllRecordsFromCurDate() {
        return recordsOfOrderRepository.getAllRecordsFromCurDate();
    }

    public void addNewOrderWithCurDate() {
        modifier.createNewOrder(getAllRecordsFromCurDate());
    }

    public void deleteOrdersThatContainTheProductWithQuantity(int productID, int quantityOfProduct) {
        List<Order> orders = ordersRepository.getNonDetOrdersByProductIDAndQuantity(productID, quantityOfProduct);

        if (!orders.isEmpty()) {
            orders.forEach(Order ->
                    Order.setRecordsOfOrder(recordsOfOrderRepository.getRecordsOfOrderByOrderID(Order.getId())));
            modifier.deleteAllOrders(orders);
        }
    }
}
