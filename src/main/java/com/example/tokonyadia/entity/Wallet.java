package com.example.tokonyadia.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable=false)
    private Customer customer;
}
