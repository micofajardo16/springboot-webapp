package com.example.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Product {

    // @Id tells jpa that its a primary key
    @Id
    private String productId;
    private String productName;
    private int price;

    public Product(String productId, String productName, int price) {
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

    @Override
    public String toString() {
        return "Product{" +
                "productId = " + productId + ", " +
                "productName = " + productName + ", " +
                "price = " + price +
                "}";
    }
}
