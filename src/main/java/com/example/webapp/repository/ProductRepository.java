package com.example.webapp.repository;

import com.example.webapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// <Entity, Primary Key>
public interface ProductRepository extends JpaRepository<Product, String> {
    
}
