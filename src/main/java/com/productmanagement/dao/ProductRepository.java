package com.productmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productmanagement.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByNameContaining(String name); // For search
}