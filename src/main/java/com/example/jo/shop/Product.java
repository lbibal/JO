package com.example.jo.shop;

public abstract class Product {
    private int id;
    private String name;
    private int price;
    private String type;
    private int qty;

    public Product(String name, int price, String type, int qty) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.qty = qty;
    }

    public Product(int id, String name, int price, String type, int qty) {
        this(name, price, type, qty);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
