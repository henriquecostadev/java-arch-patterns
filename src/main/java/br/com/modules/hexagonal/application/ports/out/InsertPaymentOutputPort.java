package br.com.modules.hexagonal.application.ports.out;

import br.com.modules.hexagonal.application.core.domain.Payment;

public interface InsertPaymentOutputPort {
    void insert(Payment payment);
}
