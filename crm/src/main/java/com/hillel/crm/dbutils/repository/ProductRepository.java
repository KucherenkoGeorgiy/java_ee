package com.hillel.crm.dbutils.repository;

import com.hillel.crm.dbutils.entity.Order;
import com.hillel.crm.dbutils.entity.Product;

import java.util.List;

/**
 * we don't need ProductRepository right now. But maybe in the future. That's why I created it
 *
 */
public class ProductRepository extends BaseRepository<Product> {
    private static final String SQL_LIST_OF_ALL_PRODUCTS = "SELECT * FROM schema_orders.product;";

    public List<Product> getAllProducts() {
        return getListWithoutID(SQL_LIST_OF_ALL_PRODUCTS,
                resultSet -> new Product(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("describing"),
                        resultSet.getInt("price")));
    }
}
