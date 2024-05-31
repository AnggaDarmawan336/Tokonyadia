package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.model.Product;
import com.example.tokonyadia.model.Transaction;
import com.example.tokonyadia.model.Wallet;
import com.example.tokonyadia.repository.TransactionRepository;
import com.example.tokonyadia.service.ProductService;
import com.example.tokonyadia.service.TransactionService;
import com.example.tokonyadia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transaction_repository;
    private final WalletService wallet_service;
    private final ProductService product_service;

    @Override
    public Transaction create(
            Transaction request,
            String wallet_id,
            Integer product_id
    ) {
        Product product = product_service.get_one(product_id);
        Wallet wallet = wallet_service.get_by_id(wallet_id);

        Integer product_price = product.getPrice();
        Integer balance = wallet.getBalance();
        Integer total_price = request.getQuantity() * product_price;

        if (balance >= total_price) {
            // kurangin saldo didompet
            wallet.setBalance(balance - total_price);
            wallet_service.update(wallet);

            // set field total_price untuk transaction
            request.setTotal_price(total_price);
            return transaction_repository.saveAndFlush(request);
        }
        return null;
    }

    @Override
    public List<Transaction> get_all() {
        return transaction_repository.findAll();
    }

    @Override
    public Transaction get_by_id(Integer id) {
        return null;
    }

    @Override
    public Transaction update(Transaction request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
