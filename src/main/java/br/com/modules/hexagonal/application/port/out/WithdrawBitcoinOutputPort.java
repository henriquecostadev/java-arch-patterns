package br.com.modules.hexagonal.application.port.out;

import java.math.BigDecimal;

public interface WithdrawBitcoinOutputPort {
    boolean withdraw(String walletId, BigDecimal amount);
}
