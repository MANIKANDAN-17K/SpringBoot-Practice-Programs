package com.example.practice.basics.controller;


import com.example.practice.basics.model.Product;
import com.example.practice.basics.service.ProductService;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestBody Product product){
        Product updateProduct = productService.updateProduct(id,product);
        if(updateProduct == null){
            return ResponseEntity.ok().body("Product not found");
        }
        return ResponseEntity.ok(updateProduct);
    }
    @PatchMapping("/product/{id}")
    public ResponseEntity<?> updatePartial(@PathVariable int id,@RequestBody Product product){
        Product updateProduct = productService.updatePartial(id,product);
        if(updateProduct == null){
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok().body(updateProduct);
    }
    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        boolean updateList = productService.deleteProduct(id);
        if(!updateList){
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok().body("Product deleted successfully");
    }
}
