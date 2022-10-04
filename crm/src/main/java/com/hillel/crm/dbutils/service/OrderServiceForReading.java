package com.hillel.crm.dbutils.service;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.entity.Product;
import com.hillel.crm.dbutils.repository.RecordsOfOrderRepository;
import com.hillel.crm.dbutils.repository.OrdersRepository;
import com.hillel.crm.dbutils.repository.ProductRepository;

import java.util.List;

public class OrderServiceForReading {
    ProductRepository productRepository;
    OrdersRepository ordersRepository;
    RecordsOfOrderRepository recordsOfOrderRepository;

    public OrderServiceForReading() {
        productRepository = new ProductRepository();
        ordersRepository = new OrdersRepository();
        recordsOfOrderRepository = new RecordsOfOrderRepository();
    }

    public Order getDetailedOrderByOrderId(int orderID) {
        Order order = ordersRepository.getNonDetailedOrderByOrderID(orderID);
        order.setRecordsOfOrder(recordsOfOrderRepository.getRecordsOfOrderByOrderID(orderID));
        return order;
    }

    public List<Order> getByTotMaxAndQuantityOfDifGoods(int totalAmount, int quantityOfDifferentGoods) {
        List<Order> result = ordersRepository
                .getNonDetOrdersByMaxTotalAndQuantityOfDifferentGoods(totalAmount, quantityOfDifferentGoods);
        result.forEach(Order -> Order.setRecordsOfOrder(recordsOfOrderRepository.getRecordsOfOrderByOrderID(Order.getId())));
        return result;
    }

    public List<Order> getAllOrders() {
        List<Order> result = ordersRepository
                .getNonDetOrdersAll();

        return result;
    }

    public List<Order> getOrdersThatContainTheProduct(int productID) {
        List<Order> result = ordersRepository.getNonDetOrdersThatContainTheProduct(productID);
        result.forEach(Order -> Order.setRecordsOfOrder(recordsOfOrderRepository.getRecordsOfOrderByOrderID(Order.getId())));
        return result;
    }

    public List<Order> getOrdersThatDoNotContainTheProductAndContainCurDate(int productID) {
        List<Order> result = ordersRepository.getNonDetOrdersThatDoNotContainTheProductAndContainCurDate(productID);
        result.forEach(Order -> Order.setRecordsOfOrder(recordsOfOrderRepository.getRecordsOfOrderByOrderID(Order.getId())));
        return result;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productRepository.getProductById(productId);
    }
}
