package br.com.modules.hexagonal.application.core.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@QuarkusTest
public class PaymentTest {

    @Test
    void shouldCreatePaymentWithAllFields() {
        Payment payment = new Payment("paymentId123", BigDecimal.valueOf(100.00), PaymentStatus.PENDING, "orderId123", PaymentMethod.CREDIT_CARD);

        Assertions.assertEquals("paymentId123", payment.getPaymentId());
        Assertions.assertEquals(BigDecimal.valueOf(100.00), payment.getAmount());
        Assertions.assertEquals(PaymentStatus.PENDING, payment.getStatus());
        Assertions.assertEquals("orderId123", payment.getOrderId());
        Assertions.assertEquals(PaymentMethod.CREDIT_CARD, payment.getMethod());
    }

    @Test
    void shouldSetAndGetPaymentId() {
        Payment payment = new Payment();
        payment.setPaymentId("paymentId123");

        Assertions.assertEquals("paymentId123", payment.getPaymentId());
    }

    @Test
    void shouldSetAndGetAmount() {
        Payment payment = new Payment();
        payment.setAmount(BigDecimal.valueOf(100.00));

        Assertions.assertEquals(BigDecimal.valueOf(100.00), payment.getAmount());
    }

    @Test
    void shouldSetAndGetStatus() {
        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.PENDING);

        Assertions.assertEquals(PaymentStatus.PENDING, payment.getStatus());
    }

    @Test
    void shouldSetAndGetOrderId() {
        Payment payment = new Payment();
        payment.setOrderId("orderId123");

        Assertions.assertEquals("orderId123", payment.getOrderId());
    }

    @Test
    void shouldSetAndGetMethod() {
        Payment payment = new Payment();
        payment.setMethod(PaymentMethod.CREDIT_CARD);

        Assertions.assertEquals(PaymentMethod.CREDIT_CARD, payment.getMethod());
    }

}
