package com.example.jo.shop.accessories;

import com.example.jo.shop.Product;

public class Accessory extends Product {

    public Accessory(String name, int price, int qty, String section) {
        super(name, price, section, qty);
    }

    public Accessory(int id, String name, int price, int qty, String section) {
        super(id, name, price, section, qty);
    }
}
