package br.com.modules.hexagonal.application.port.out;

import br.com.modules.hexagonal.application.core.domain.Payment;

import java.util.List;

public interface SelectAllPaymentsOutputPort {
    List<Payment> selectAll();
}
