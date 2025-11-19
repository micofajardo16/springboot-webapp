package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.webapp.model.Product;
import com.example.webapp.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    // @RequestMapping("/products")
    // Swapped to getMapping
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return service.getProductById(productId);
    }

    // Try using same URL
    // without @RequestBody -> USE Params
        // Spring will use DataBinder
        // JSON doesnt work because Spring does not read JSON from the Request Body

    // with @RequestBody -> USE JSON
        // Spring will use DataBinder
        // Spring now expects the entire request body to be JSON and it will not look at URL params
        // it is best practice to use @RequestBody
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        service.deleteProduct(productId);
    }


    // REMAKE EVERYTHING, Request and Response must be in Dto
}
