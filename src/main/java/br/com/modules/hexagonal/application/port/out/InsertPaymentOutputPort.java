package br.com.modules.hexagonal.application.port.out;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface InsertPaymentOutputPort {
    String insert(Payment payment);
}
