package com.example.practice.basics.service;

import com.example.practice.basics.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> prod = new ArrayList<>();
    private final List<Product> productList = List.of(new Product(1,"laptop",50000),
            new Product(2,"mobile",20000),
            new Product(3,"tablet",30000),
            new Product(4,"headphones",5000),
            new Product(5,"smartwatch",10000)
    );
    public List<Product> getProduct(){
        return productList;
    }
    public Product getProductById(int id){
        for(Product prod : productList){
            if(prod.getId() == id){
                return prod;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        prod.add(product);
    }
}
