package com.example.practice.basics.controller;


import com.example.practice.basics.model.Product;
import com.example.practice.basics.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProduct();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PostMapping
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "Product added successfully";
    }

}
