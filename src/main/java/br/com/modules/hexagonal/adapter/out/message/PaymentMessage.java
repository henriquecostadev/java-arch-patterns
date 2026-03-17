package br.com.modules.hexagonal.adapter.out.message;

import br.com.modules.hexagonal.application.core.domain.PaymentMethod;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PaymentMessage {
    private String paymentId;
    private BigDecimal amount;
    private PaymentStatus status;
    private String orderId;
    private PaymentMethod method;
}
