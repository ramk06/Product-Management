package com.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productmanagement.entities.Products;
import com.productmanagement.services.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/hello")
    public String getProducts() {
        return "List of products";
    }

    // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> list = productService.getAllProducts();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }

    // Get a single product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") Long id) {
        try {
            Products product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create a new product
    @PostMapping("/products")
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        try {
            Products savedProduct = productService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a product by ID
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update an existing product
    @PutMapping("/products/{id}")
    public ResponseEntity<Products> updateProduct(@RequestBody Products product, @PathVariable("id") Long id) {
        try {
            Products updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
