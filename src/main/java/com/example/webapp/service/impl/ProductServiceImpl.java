package com.example.webapp.service.impl;

// import java.util.Arrays;
import java.util.List;
// import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.dto.ProductDto;
import com.example.webapp.model.Product;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // asList creates an immutable list 
    // List<Product> products = Arrays.asList(
    //     new Product("001", "Pipe", 10),
    //     new Product("002", "Box", 20),
    //     new Product("003", "Paint", 30)
    // );

    // @Autowired
    // Autowired no longer needed with RequiredArgsConstructor
    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    // public List<Product> getProducts() {
    //     // return this.products;
    //     return repository.findAll();
    // }

    // public Product getProductById(String productId) {
    //     // return this.products.stream()
    //     //             .filter(p -> p.getProductId().equals(productId))
    //     //             .findFirst()
    //     //             .orElse(new Product("000", "None", 0));
    //     return repository.getReferenceById(productId);
    // }

    // public void addProduct(Product product) {
    //     // System.out.print("Created a new product: " + product);
    //     // this.products.add(product);
    //     repository.save(product);
    // }

    // public void updateProduct(Product product) {
    //     // int indexOfProduct = 0;
    //     // for (int i = 0; i < this.products.size(); i++) {
    //     //     if (this.products.get(i).getProductId().equals(product.getProductId())) {
    //     //         indexOfProduct = i;
    //     //     }
    //     // }
    //     // this.products.set(indexOfProduct, product);
    //     repository.save(product);
    // }

    // public void deleteProduct(String productId) {
    //     // int indexOfProduct = 0;
    //     // for (int i = 0; i < this.products.size(); i++) {
    //     //     if (products.get(i).getProductId().equals(productId)) {
    //     //         indexOfProduct = i;
    //     //     }
    //     // }
    //     // products.remove(indexOfProduct);
    //     repository.deleteById(productId);
    // }


    // REMAKE everything above, moving to DTO implementation
    public List<ProductDto> getProducts() {
        List<Product> products = repository.findAll();

        // The modelMapper must be an attribute of the ServiceImpl
        // And do not forget the RequiredArgsConstructor
        // And of course, do not forget to change in the interface level
        return products.stream().map(product ->
            modelMapper.map(product, ProductDto.class)).toList();

    }

    public ProductDto getProductById(String productId) {
        Product product = repository.getReferenceById(productId);
        return modelMapper.map(product, ProductDto.class);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product productToAdd = modelMapper.map(productDto, Product.class);
        repository.save(productToAdd);
        return modelMapper.map(productToAdd, ProductDto.class);
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Product findProduct = repository.findById(productDto.getProductId())
            .orElseThrow(() -> new RuntimeException("Product not found"));

        modelMapper.map(productDto, findProduct);

        Product updatedProduct = repository.save(findProduct);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    public ProductDto deleteProduct(String productId) {
        Product findProduct = repository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        repository.delete(findProduct);
        return modelMapper.map(findProduct, ProductDto.class);
    }
}
