package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.entity.Customer;
import com.example.tokonyadia.repository.CustomerRepository;
import com.example.tokonyadia.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Page<Customer> get_all(Integer offset, Integer limit) {
//        if (offset != null && limit != null) {
            return customer_repository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "name")));
//        }
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
