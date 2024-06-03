package com.example.tokonyadia.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {
    private String id;
    private Integer balance;
    private String customer_id;
}