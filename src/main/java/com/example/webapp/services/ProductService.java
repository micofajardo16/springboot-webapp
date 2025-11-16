package com.example.webapp.services;

import com.example.webapp.models.Product;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
        new Product("001", "Pipe", 10),
        new Product("002", "Box", 20),
        new Product("003", "Paint", 30)
    );

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProductById(String prodId) {
        // return this.products.stream()
        //             .filter(p -> p.getProductId().equals(productId)
        //             .findFirst().get());
        return null;
    }
}
