package br.com.modules.hexagonal.application.port.in;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface CreateBitcoinPaymentInputPort {
    String create(Payment payment, String walletId);
}
