package br.com.modules.hexagonal.application.ports.in;

public interface RefundPaymentInputPort {
    void refund(String paymentId);
}
