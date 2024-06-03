package com.example.tokonyadia.controller;


import com.example.tokonyadia.entity.Transaction;
import com.example.tokonyadia.service.TransactionService;
import com.example.tokonyadia.utils.response.WebResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/transactions")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transaction_service;

    @PostMapping
    public ResponseEntity<WebResponse<Transaction>> create(
            @RequestBody Transaction request,
            @RequestParam String wallet_id,
            @RequestParam Integer product_id
    ) {
        Transaction transaction = transaction_service.create(request, wallet_id, product_id);
        WebResponse<Transaction> response = WebResponse.<Transaction>builder()
                .message("Transaction Created Successfully")
                .data(transaction)
                .build();
        return ResponseEntity.ok(response);
    }

//    // TODO:
//     1. aplikasikan WebResponse -> Product, Customer dan Wallet
//     2. Buat Get_All, Get_By_id , Delete untuk Transaksi
//     3. Push branch hands-on web_reponse
}
