package com.example.tokonyadia.controller;

import com.example.tokonyadia.dto.request.WalletRequest;
import com.example.tokonyadia.dto.response.WalletResponse;
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
    public WalletResponse create_wallet(
            @RequestBody WalletRequest request
    ) {
        return wallet_service.create(request);
    }
}
