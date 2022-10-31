package com.hillel.crm.repository;

import com.hillel.crm.entity.Order;

import java.util.List;

public class OrdersRepository extends BaseRepository<Order> {

    private static final String HQL_LIST_OF_CONTAINING_PRODUCT = """
            select o from Order o
            join o.recordsOfOrder r
            join r.product p
            where p.id=:ida""";

    private static final String HQL_LIST_OF_DO_NOT_CONTAIN_PROD = """
            select  o from Order o
            where not exists (select m from Order m
            join m.recordsOfOrder r
            join r.product p
            where m.id = o.id and p.id=:ida)
            and o.date=CURDATE()""";

    private static final String HQL_GET_ORDER_BY_ID = "select o from Order o where o.id = :ida";
    private static final String HQL_GET_ALL_ORDERS = "select o from Order o";
    private static final String HQL_GET_ALL_ORDERS_FROM_TODAY = "select o from Order o where o.date=curdate()";

    private static final String HQL_LIST_OF_FILTER_TOTAL_AND_QUANTITY = """
            select o from Order o
            join o.recordsOfOrder r
            join r.product p
            Group by o.id
            having SUM(quantityOfProduct*price)<:ida and count(p.id)=:idb
            order by o.id""";

    private static final String HQL_LIST_OF_FILTER_PRODUCT_AND_QUANTITY = """
            select o from Order o
            join o.recordsOfOrder r
            join r.product p
            where p.id = :ida
            Group by o.id
            having SUM(r.quantityOfProduct)=:idb
            order by o.id""";

    public List<Order> getNonDetOrdersByMaxTotalAndQuantityOfDifferentGoods(int maxTotal, int quantityOfDifferentGoods) {
        return getListWithTwoParameters(maxTotal, quantityOfDifferentGoods, HQL_LIST_OF_FILTER_TOTAL_AND_QUANTITY, Order.class);
    }

    public List<Order> getNonDetOrdersByProductIDAndQuantity(int productID, int quantityOfGoods) {
        return getListWithTwoParameters(productID, quantityOfGoods, HQL_LIST_OF_FILTER_PRODUCT_AND_QUANTITY, Order.class);
    }

    public List<Order> getNonDetOrdersThatContainTheProduct(int productID) {
        return getListWithOneParameter(productID, HQL_LIST_OF_CONTAINING_PRODUCT, Order.class);
    }

    public List<Order> getNonDetOrdersThatDoNotContainTheProductAndContainCurDate(int productID) {
        return getListWithOneParameter(productID, HQL_LIST_OF_DO_NOT_CONTAIN_PROD, Order.class);
    }

    public List<Order> getNonDetOrdersAll() {
        return getListWithoutParameter(HQL_GET_ALL_ORDERS, Order.class);
    }

    public Order getDetailedOrderByOrderID(int orderID) {
        return getListWithOneParameter(orderID, HQL_GET_ORDER_BY_ID, Order.class).get(0);
    }
}

