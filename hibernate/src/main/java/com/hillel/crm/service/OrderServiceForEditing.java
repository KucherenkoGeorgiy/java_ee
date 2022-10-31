package com.hillel.crm.service;

import com.hillel.crm.entity.Order;
import com.hillel.crm.entity.RecordsOfOrder;
import com.hillel.crm.modifier.Modifier;
import com.hillel.crm.repository.OrdersRepository;
import com.hillel.crm.repository.RecordsOfOrderRepository;

import java.util.List;

public class OrderServiceForEditing {
    private OrdersRepository ordersRepository;
    private RecordsOfOrderRepository recordsOfOrderRepository;
    private Modifier modifier;


    public OrderServiceForEditing() {
        ordersRepository = new OrdersRepository();
        recordsOfOrderRepository = new RecordsOfOrderRepository();
        modifier = new Modifier();
    }

    public int addNewOrderWithCurDate() {
        return modifier.createNewOrder(recordsOfOrderRepository.getAllRecordsFromCurDate());
    }

    public List<Order> deleteOrdersThatContainTheProductWithQuantity(int productID, int quantityOfProduct) {
        List<Order> orders = ordersRepository.getNonDetOrdersByProductIDAndQuantity(productID, quantityOfProduct);

        if (!orders.isEmpty()) {
            modifier.deleteAllOrders(orders);
            return orders;
        } else {
            return List.of();
        }
    }
}
