package com.hillel.crm.repository;

import com.hillel.crm.entity.Product;

import java.util.List;

public class ProductRepository extends BaseRepository<Product> {
    private static final String SQL_LIST_OF_ALL_PRODUCTS = "SELECT * FROM schema_orders.product;";
    private static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM schema_orders.product where id=?;";

    public List<Product> getAllProducts() {
        return getListWithoutID(SQL_LIST_OF_ALL_PRODUCTS,
                resultSet -> new Product(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("describing"),
                        resultSet.getInt("price")));
    }

    public Product getProductById(int productId) {
        return getListByID(productId, SQL_FIND_PRODUCT_BY_ID,
                resultSet -> new Product(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("describing"),
                        resultSet.getInt("price"))).get(0);
    }
}
