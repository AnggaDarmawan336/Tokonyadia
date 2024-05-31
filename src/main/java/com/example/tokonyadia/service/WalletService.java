package com.example.tokonyadia.service;

import com.example.tokonyadia.model.Wallet;

import java.util.List;

public interface WalletService {
    Wallet create(Wallet request, String customer_id);
    List<Wallet> get_all();
    Wallet get_by_id(String id);
    Wallet update(Wallet request);
    void delete(String id);
}
