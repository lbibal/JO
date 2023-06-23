package com.example.jo.shop;

import java.util.List;

public interface ShopService<T> {

    Product addNewProduct(T newProduct);

    Product decreaseProductQty(String productId);

    List<Product> listAvailableProducts();

    Product getProductWithId(String id);
}
