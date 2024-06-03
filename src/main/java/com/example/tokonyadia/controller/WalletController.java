package com.example.tokonyadia.controller;

import com.example.tokonyadia.entity.Wallet;
import com.example.tokonyadia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class WalletController {
    private final WalletService wallet_service;

    @PostMapping
    public Wallet create_wallet(
            @RequestBody Wallet request
    ) {
        return wallet_service.create(request);
    }
}
