package br.com.modules.hexagonal.adapter.in.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardRequest {
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;
}
