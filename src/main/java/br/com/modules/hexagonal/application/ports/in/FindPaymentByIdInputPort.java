package br.com.modules.hexagonal.application.ports.in;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface FindPaymentByIdInputPort {
    Payment find(String paymentId);
}
