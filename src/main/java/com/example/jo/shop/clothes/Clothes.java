package com.example.jo.shop.clothes;

import com.example.jo.shop.Product;

public class Clothes extends Product {

    private final String size;

    public Clothes(String name, int price, int qty, String size) {
        super(name, price, Clothes.class.getSimpleName(), qty);
        this.size = size;
    }

    public Clothes(int id, String name, int price, int qty, String size) {
        super(id, name, price, Clothes.class.getSimpleName(), qty);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
