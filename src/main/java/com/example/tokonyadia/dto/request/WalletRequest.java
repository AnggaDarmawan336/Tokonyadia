package com.example.tokonyadia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {
    private String id;

    @Schema(description = "Balance of the wallet", example = "10000")
    private Integer balance;

    @Schema(description = "ID of the customer (UUID)", example = "cce3b8b7-8bc7-4e18-8f9b-b7d01d73ae09")
    private String customer_id;
}
