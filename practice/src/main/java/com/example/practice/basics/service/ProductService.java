package com.example.practice.basics.service;

import com.example.practice.basics.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> prodd = new ArrayList<>();
    private final List<Product> productList = List.of(
            new Product(1,"laptop",50000.0),
            new Product(2,"mobile",20000.0),
            new Product(3,"tablet",30000.0),
            new Product(4,"headphones",5000.0),
            new Product(5,"smartwatch",10000.0)
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
        prodd.add(product);
    }
    public Product updateProduct(int id,Product product){
        for(Product prod : productList){
            if(prod.getId() == id){
                prod.setName(product.getName());
                prod.setPrice(product.getPrice());
                return prod;
            }
        }
        return null;
    }
    public Product updatePartial(int id,Product product){
        for(Product prod : productList){
            if(id == prod.getId()) {
                if (product.getName() != null) {
                    prod.setName(product.getName());
                }
                if (product.getPrice() != null) {
                    prod.setPrice(product.getPrice());
                }
                return prod;
            }
        }
        return null;
    }
    public Boolean deleteProduct(int id) {
        return prodd.removeIf(prod -> prod.getId() == id);
    }
}
