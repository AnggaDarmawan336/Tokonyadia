package com.example.tokonyadia.controller;

import com.example.tokonyadia.entity.Customer;
import com.example.tokonyadia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/customers")
@AllArgsConstructor
public class CustomerV2Controller {
    private final CustomerService customer_service;

    @PostMapping
    public Customer create_customer(@RequestBody Customer request) {
        return customer_service.create(request);
    }

    @GetMapping
    public Page<Customer> get_all(Integer offset, Integer limit) {
        return customer_service.get_all(offset, limit);
    }

    @GetMapping(path = "/{id}")
    public Customer get_by_id(@PathVariable String id) {
        return customer_service.get_by_id(id);
    }

    @PutMapping
    public Customer update(@RequestBody Customer request) {
        return customer_service.update(request);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        customer_service.delete(id);
    }

}
