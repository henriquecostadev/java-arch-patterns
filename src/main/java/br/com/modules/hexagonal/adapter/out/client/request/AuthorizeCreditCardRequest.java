package br.com.modules.hexagonal.adapter.out.client.request;

import br.com.modules.hexagonal.application.core.domain.CreditCard;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AuthorizeCreditCardRequest {
    private CreditCard creditCard;
    private BigDecimal amount;
}
