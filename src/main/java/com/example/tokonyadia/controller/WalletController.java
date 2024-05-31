package com.example.tokonyadia.controller;

import com.example.tokonyadia.model.Wallet;
import com.example.tokonyadia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class WalletController {
    private final WalletService wallet_service;

    @PostMapping("/{customer_id}")
    public Wallet create_wallet(
            @RequestBody Wallet request,
            @PathVariable String customer_id
    ) {
        return wallet_service.create(request, customer_id);
    }
}
