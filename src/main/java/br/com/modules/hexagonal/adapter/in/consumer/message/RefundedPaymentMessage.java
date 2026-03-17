package br.com.modules.hexagonal.adapter.in.consumer.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundedPaymentMessage {
    private String paymentId;
    private String reason;
}
