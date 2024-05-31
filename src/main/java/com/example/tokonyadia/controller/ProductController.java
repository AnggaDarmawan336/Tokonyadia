package com.example.tokonyadia.controller;

import com.example.tokonyadia.model.Product;
import com.example.tokonyadia.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService product_service;

    @PostMapping
    public Product create(@RequestBody Product request) {
        return product_service.create(request);
    }

    @GetMapping
    public List<Product> get_all() {
        return product_service.get_all();
    }

    @GetMapping(path = "/{id}")
    public Product get_one(@PathVariable Integer id) {
        return product_service.get_one(id);
    }

    @PutMapping(path = "/{id}")
    public Product update(@RequestBody Product request) {
        return product_service.update(request);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        product_service.delete(id);
    }
}
