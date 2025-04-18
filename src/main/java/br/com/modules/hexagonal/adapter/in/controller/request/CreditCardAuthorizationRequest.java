package br.com.modules.hexagonal.adapter.in.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditCardAuthorizationRequest {
    private BigDecimal amount;
    private String orderId;
    private CreditCardRequest creditCard;
}
