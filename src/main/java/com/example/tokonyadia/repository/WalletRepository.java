package com.example.tokonyadia.repository;

import com.example.tokonyadia.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}
