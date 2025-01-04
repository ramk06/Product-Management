package com.productmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.dao.ProductRepository;
import com.productmanagement.entities.Products;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Fetch all products
    public List<Products> getAllProducts() {
        return  productRepository.findAll();
    }

    // Fetch product by ID
    public Products getProductById(Long id) {
        return  productRepository.findById(id)
                         .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // Create a new product
    public Products createProduct(Products product) {
        return  productRepository.save(product);
    }

    // Update an existing product
    public Products updateProduct(Long id, Products productDetails) {
        // Fetch product by ID or throw an exception if not found
        Products existingProduct = getProductById(id);

        // Update fields
        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setQuantity(productDetails.getQuantity());

        // Save updated product
        return  productRepository.save(existingProduct);
    }

    // Delete a product
    public void deleteProduct(Long id) {
        // Fetch product by ID or throw an exception if not found
        Products product = getProductById(id);

        // Delete product
        productRepository.delete(product);
    }
}
