package com.example.webapp.controller;

import org.springframework.http.ResponseEntity;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.webapp.exception.StatusCode;
import com.example.webapp.model.Product;
import com.example.webapp.service.ProductService;
import com.example.webapp.dto.ResponseDto;
import com.example.webapp.dto.ProductDto;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    // @RequestMapping("/products")
    // Swapped to getMapping
    // @GetMapping("/products")
    // public List<Product> getProducts() {
    //     return service.getProducts();
    // }

    // @GetMapping("/products/{productId}")
    // public Product getProductById(@PathVariable String productId) {
    //     return service.getProductById(productId);
    // }

    // Try using same URL
    // without @RequestBody -> USE Params
        // Spring will use DataBinder
        // JSON doesnt work because Spring does not read JSON from the Request Body

    // with @RequestBody -> USE JSON
        // Spring will use DataBinder
        // Spring now expects the entire request body to be JSON and it will not look at URL params
        // it is best practice to use @RequestBody
    // @PostMapping("/products")
    // public void addProduct(@RequestBody Product product) {
    //     service.addProduct(product);
    // }

    // @PutMapping("/products")
    // public void updateProduct(@RequestBody Product product) {
    //     service.updateProduct(product);
    // }

    // @DeleteMapping("/products/{productId}")
    // public void deleteProduct(@PathVariable String productId) {
    //     service.deleteProduct(productId);
    // }


    // REMAKE EVERYTHING, Request and Response must be in Dto

    @GetMapping("/products")
    public ResponseEntity<ResponseDto<List<ProductDto>>> getProducts() {
        List<ProductDto> products = service.getProducts();
        return ResponseEntity.ok(ResponseDto.<List<ProductDto>>builder()
                .body(products)
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ResponseDto<ProductDto>> getProductById(@PathVariable String productId) {
        ProductDto product = service.getProductById(productId);
        return ResponseEntity.ok(ResponseDto.<ProductDto>builder()
                .body(product)
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build());
    }


    // OLD: public ResponseEntity<ResponseDto<ProductDto>> addProduct(@RequestBody Product product) {
    // NEW: you want the argument to be a Dto
    @PostMapping("/products")
    public ResponseEntity<ResponseDto<ProductDto>> addProduct(@RequestBody ProductDto productDto) {
        ProductDto product = service.addProduct(productDto);
        return ResponseEntity.ok(ResponseDto.<ProductDto>builder()
                .body(product)
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build());
    }

    @PutMapping("/products")
    public ResponseEntity<ResponseDto<ProductDto>> updateProduct(@RequestBody ProductDto productDto) {
        ProductDto product = service.updateProduct(productDto);
        return ResponseEntity.ok(ResponseDto.<ProductDto>builder()
                .body(product)
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build());
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<ResponseDto<ProductDto>> deleteProduct(@PathVariable String productId) {
        ProductDto product = service.deleteProduct(productId);
        return ResponseEntity.ok(ResponseDto.<ProductDto>builder()
                .body(product)
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build());
    }
}
