package com.example.webapp.services;

import com.example.webapp.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    // asLIst creates an immutable list 
    // List<Product> products = Arrays.asList(
    //     new Product("001", "Pipe", 10),
    //     new Product("002", "Box", 20),
    //     new Product("003", "Paint", 30)
    // );

    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product("001", "Pipe", 10),
        new Product("002", "Box", 20),
        new Product("003", "Paint", 30)
    ));

    public List<Product> getProducts() {
        return this.products;
    }

    public Product getProductById(String productId) {
        return this.products.stream()
                    .filter(p -> p.getProductId().equals(productId))
                    .findFirst()
                    .orElse(new Product("000", "None", 0));
    }

    public void addProduct(Product product) {
        System.out.print("Created a new product: " + product);
        this.products.add(product);
    }

    public void updateProduct(Product product) {
        int indexOfProduct = 0;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getProductId().equals(product.getProductId())) {
                indexOfProduct = i;
            }
        }
        this.products.set(indexOfProduct, product);
    }

    public void deleteProduct(String productId) {
        int indexOfProduct = 0;
        for (int i = 0; i < this.products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                indexOfProduct = i;
            }
        }
        products.remove(indexOfProduct);
    }
}
