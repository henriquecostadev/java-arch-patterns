package br.com.modules.hexagonal.application.port.out;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface SelectPaymentByIdOutputPort {
    Payment select(String paymentId);
}
