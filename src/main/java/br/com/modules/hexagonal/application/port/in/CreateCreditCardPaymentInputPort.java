package br.com.modules.hexagonal.application.port.in;

import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.core.domain.Payment;

public interface CreateCreditCardPaymentInputPort {
    String create(Payment payment, CreditCard creditCard);
}
