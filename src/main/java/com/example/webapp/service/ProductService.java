package com.example.webapp.service;

import java.util.List;

import com.example.webapp.model.Product;
import com.example.webapp.dto.ProductDto;

public interface ProductService {
    // List<Product> getProducts();
    // Product getProductById(String productId);
    // void addProduct(Product product);
    // void updateProduct(Product product);
    // void deleteProduct(String productId);


    List<ProductDto> getProducts();
    ProductDto getProductById(String productId);
    ProductDto addProduct(ProductDto productdto);
    ProductDto updateProduct(ProductDto productDto);
    ProductDto deleteProduct(String productId);

}
