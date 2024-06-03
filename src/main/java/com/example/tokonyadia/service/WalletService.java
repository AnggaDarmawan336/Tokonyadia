package com.example.tokonyadia.service;

import com.example.tokonyadia.dto.request.WalletRequest;
import com.example.tokonyadia.dto.response.WalletResponse;
import com.example.tokonyadia.entity.Wallet;

import java.util.List;

public interface WalletService {
    WalletResponse create(WalletRequest request);
    List<Wallet> get_all();
    Wallet get_by_id(String id);
    Wallet update(Wallet request);
    void delete(String id);
}
