package br.com.modules.hexagonal.adapter.in.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BitcoinWithdrawRequest {
    private String walletId;
    private BigDecimal amount;
    private String orderId;
}
