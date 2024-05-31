package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.model.Customer;
import com.example.tokonyadia.repository.CustomerRepository;
import com.example.tokonyadia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customer_repository;

    @Override
    public Customer create(Customer request) {
        return customer_repository.saveAndFlush(request);
    }

    @Override
    public List<Customer> get_all() {
        return customer_repository.findAll();
    }

    @Override
    public Customer get_by_id(String id) {
        Optional<Customer> customer = customer_repository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer update(Customer request) {
        this.get_by_id(request.getId());
        return customer_repository.save(request);
    }

    @Override
    public void delete(String id) {
        this.get_by_id(id);
        customer_repository.deleteById(id);
    }
}
