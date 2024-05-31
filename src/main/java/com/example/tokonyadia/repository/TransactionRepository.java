package com.example.tokonyadia.repository;

import com.example.tokonyadia.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
