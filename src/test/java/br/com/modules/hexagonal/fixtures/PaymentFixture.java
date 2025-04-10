package br.com.modules.hexagonal.fixtures;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentMethod;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;

import java.math.BigDecimal;

public class PaymentFixture {

    public static Payment getPayment(){
        Payment payment = new Payment();
        payment.setPaymentId("1");
        payment.setAmount(new BigDecimal(100));
        payment.setStatus(PaymentStatus.COMPLETED);
        payment.setOrderId("1");
        payment.setMethod(PaymentMethod.BITCOIN);
        return payment;
    }
}
