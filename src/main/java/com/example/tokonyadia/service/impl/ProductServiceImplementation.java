package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.entity.Product;
import com.example.tokonyadia.repository.ProductRepository;
import com.example.tokonyadia.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository product_repository;

    @Override
    public Product create(Product request) {
        return product_repository.saveAndFlush(request);
    }

    @Override
    public List<Product> get_all() {
        return product_repository.findAll();
    }

    @Override
    public Product get_one(Integer id) {
        Optional<Product> product = product_repository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product update(Product request) {
        this.get_one(request.getId());
        return product_repository.save(request);
    }

    @Override
    public void delete(Integer id) {
        this.get_one(id);
        product_repository.deleteById(id);
    }
}
