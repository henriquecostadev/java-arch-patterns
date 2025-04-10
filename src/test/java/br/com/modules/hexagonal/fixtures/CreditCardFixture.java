package br.com.modules.hexagonal.fixtures;

import br.com.modules.hexagonal.application.core.domain.CreditCard;

public class CreditCardFixture {
    public static CreditCard getCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("1234567890123456");
        creditCard.setCardHolder("John Doe");
        creditCard.setExpirationDate("12/25");
        creditCard.setCvv("123");
        return creditCard;
    }
}
