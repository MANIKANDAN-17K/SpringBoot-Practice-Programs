package com.example.practice.basics.repository;

import com.example.practice.basics.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
        public Product findById(int id);
}

