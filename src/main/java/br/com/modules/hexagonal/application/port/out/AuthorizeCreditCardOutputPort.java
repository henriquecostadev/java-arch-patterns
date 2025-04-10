package br.com.modules.hexagonal.application.port.out;

import br.com.modules.hexagonal.application.core.domain.CreditCard;

import java.math.BigDecimal;

public interface AuthorizeCreditCardOutputPort {
    boolean autorize(CreditCard creditCard, BigDecimal amount);
}
