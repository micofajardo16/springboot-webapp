package com.example.webapp.models;

public class Product {
    
    private String productId;
    private String productName;
    private int price;

    public Product(String productName, String productId, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getPrice() {
        return this.price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
