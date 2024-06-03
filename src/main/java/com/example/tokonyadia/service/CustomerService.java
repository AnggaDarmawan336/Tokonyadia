package com.example.tokonyadia.service;

import com.example.tokonyadia.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer create(Customer request);
//    List<Customer> get_all();
    Page<Customer> get_all(Integer offset, Integer limit);
    Customer get_by_id(String id);
    Customer update(Customer request);
    void delete(String id);
}
