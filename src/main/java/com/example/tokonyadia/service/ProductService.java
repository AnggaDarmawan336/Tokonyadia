package com.example.tokonyadia.service;

import com.example.tokonyadia.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product request);
    List<Product> get_all();
    Product get_one(Integer id);
    Product update(Product request);
    void delete(Integer id);
}
