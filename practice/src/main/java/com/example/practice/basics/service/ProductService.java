package com.example.practice.basics.service;

import com.example.practice.basics.model.Product;
import com.example.practice.basics.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private final List<Product> prodd = new ArrayList<>();
    private final List<Product> productList = List.of(
            new Product("laptop",50000.0),
            new Product("mobile",20000.0),
            new Product("tablet",30000.0),
            new Product("headphones",5000.0),
            new Product("smartwatch",10000.0)
    );
    public Page<Product> getProducts(int page, int size){
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("price").ascending()
        );
        return productRepository.findAll(pageable);
    }
    public List<Product> getProduct(){
        return productList;
    }
    public Product getProductById(int id){
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
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
