package com.example.webapp.service;

import java.util.List;

import com.example.webapp.model.Product;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(String productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);
}
