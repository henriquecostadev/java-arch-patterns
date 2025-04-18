package br.com.modules.hexagonal.adapter.out.repository.entity;

import br.com.modules.hexagonal.application.core.domain.PaymentMethod;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentEntity {
    private String paymentId;
    private BigDecimal amount;
    private PaymentStatus status;
    private String orderId;
    private PaymentMethod method;
}
