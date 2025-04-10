package br.com.modules.hexagonal.application.ports.out;

import java.math.BigDecimal;

public interface WithdrawBitcoinOutputPort {
    boolean withdraw(String walletId, BigDecimal amount);
}
