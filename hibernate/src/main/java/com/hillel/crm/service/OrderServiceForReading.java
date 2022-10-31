package com.hillel.crm.service;

import com.hillel.crm.entity.Order;
import com.hillel.crm.entity.Product;
import com.hillel.crm.repository.RecordsOfOrderRepository;
import com.hillel.crm.repository.OrdersRepository;
import com.hillel.crm.repository.ProductRepository;

import java.util.List;

public class OrderServiceForReading {
    private ProductRepository productRepository;
    private OrdersRepository ordersRepository;
    private RecordsOfOrderRepository recordsOfOrderRepository;

    public OrderServiceForReading() {
        productRepository = new ProductRepository();
        ordersRepository = new OrdersRepository();
        recordsOfOrderRepository = new RecordsOfOrderRepository();
    }

    public Order getDetailedOrderByOrderId(int orderID) throws NullPointerException {
        return ordersRepository.getDetailedOrderByOrderID(orderID);
    }

    public List<Order> getByTotMaxAndQuantityOfDifGoods(int totalAmount, int quantityOfDifferentGoods) {
        return ordersRepository.getNonDetOrdersByMaxTotalAndQuantityOfDifferentGoods(totalAmount, quantityOfDifferentGoods);
    }

    public List<Order> getAllOrders() {
        return ordersRepository.getNonDetOrdersAll();
    }

    public List<Order> getOrdersThatContainTheProduct(int productID) {
        return ordersRepository.getNonDetOrdersThatContainTheProduct(productID);
    }

    public List<Order> getOrdersThatDoNotContainTheProductAndContainCurDate(int productID) {
        return ordersRepository.getNonDetOrdersThatDoNotContainTheProductAndContainCurDate(productID);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

}

