package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.model.Customer;
import com.example.tokonyadia.model.Wallet;
import com.example.tokonyadia.repository.WalletRepository;
import com.example.tokonyadia.service.CustomerService;
import com.example.tokonyadia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final CustomerService customer_service;
    private final WalletRepository wallet_repository;

    @Override
    public Wallet create(Wallet request, String customer_id) {
        Customer customer = customer_service.get_by_id(customer_id);
        request.setCustomer(customer);
        return wallet_repository.saveAndFlush(request);
    }

    @Override
    public List<Wallet> get_all() {
        return wallet_repository.findAll();
    }

    @Override
    public Wallet get_by_id(String id) {
        Optional<Wallet> wallet = wallet_repository.findById(id);
        return wallet.orElse(null);
    }

    @Override
    public Wallet update(Wallet request) {
        this.get_by_id(request.getId());
        return wallet_repository.save(request);
    }

    @Override
    public void delete(String id) {
        this.get_by_id(id);
        wallet_repository.deleteById(id);
    }
}
