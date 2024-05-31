package com.example.tokonyadia.service;

import com.example.tokonyadia.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer request);
    List<Customer> get_all();
    Customer get_by_id(String id);
    Customer update(Customer request);
    void delete(String id);
}
