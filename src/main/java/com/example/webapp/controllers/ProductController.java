package com.example.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.models.Product;
import com.example.webapp.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @RequestMapping("")
    public Product getProductById(String productId) {
        return service.getProductById(productId);
    }
}
