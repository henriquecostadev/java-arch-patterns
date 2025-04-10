package br.com.modules.hexagonal.application.port.in;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface FindPaymentByIdInputPort {
    Payment find(String paymentId);
}
