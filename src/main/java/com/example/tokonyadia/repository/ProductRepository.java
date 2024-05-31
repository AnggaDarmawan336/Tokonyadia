package com.example.tokonyadia.repository;

import com.example.tokonyadia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
