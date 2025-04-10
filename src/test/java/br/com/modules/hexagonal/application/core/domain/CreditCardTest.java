package br.com.modules.hexagonal.application.core.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class CreditCardTest {
    @Test
    void shouldCreateCreditCardWithAllFields() {
        CreditCard creditCard = new CreditCard("1234567890123456", "John Doe", "12/25", "123");

        Assertions.assertEquals("1234567890123456", creditCard.getCardNumber());
        Assertions.assertEquals("John Doe", creditCard.getCardHolder());
        Assertions.assertEquals("12/25", creditCard.getExpirationDate());
        Assertions.assertEquals("123", creditCard.getCvv());
    }

    @Test
    void shouldSetAndGetCardNumber() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("1234567890123456");

        Assertions.assertEquals("1234567890123456", creditCard.getCardNumber());
    }

    @Test
    void shouldSetAndGetCardHolder() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardHolder("John Doe");

        Assertions.assertEquals("John Doe", creditCard.getCardHolder());
    }

    @Test
    void shouldSetAndGetExpirationDate() {
        CreditCard creditCard = new CreditCard();
        creditCard.setExpirationDate("12/25");

        Assertions.assertEquals("12/25", creditCard.getExpirationDate());
    }

    @Test
    void shouldSetAndGetCvv() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCvv("123");

        Assertions.assertEquals("123", creditCard.getCvv());
    }
}
