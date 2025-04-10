package br.com.modules.hexagonal.application.ports.in;

import br.com.modules.hexagonal.application.core.domain.Payment;

import java.util.List;

public interface ListPaymentsInputPort {
    List<Payment> list();
}
