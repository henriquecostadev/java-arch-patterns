package br.com.modules.hexagonal.adapter.out.client.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WithdrawBitcoinRequest {
    private String walletId;
    private BigDecimal amount;
}
