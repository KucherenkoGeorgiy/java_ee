package com.hillel.crm.repository;

import com.hillel.crm.entity.Product;

import java.util.List;

public class ProductRepository extends BaseRepository<Product> {
    private static final String HQL_LIST_OF_ALL_PRODUCTS = "select o from Product o";
    private static final String HQL_FIND_PRODUCT_BY_ID = "select o from Product o where o.id=:ida";

    public List<Product> getAllProducts() {
        return getListWithoutParameter(HQL_LIST_OF_ALL_PRODUCTS, Product.class);
    }

    public Product getProductById(int productId) {
        return getListWithOneParameter(productId, HQL_FIND_PRODUCT_BY_ID, Product.class).get(0);
    }
}
