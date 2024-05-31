package com.example.tokonyadia.service;

import com.example.tokonyadia.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create(Transaction request, String wallet_id, Integer product_id);
    List<Transaction> get_all();
    Transaction get_by_id(Integer id);
    Transaction update(Transaction request);
    void delete(Integer id);
}
