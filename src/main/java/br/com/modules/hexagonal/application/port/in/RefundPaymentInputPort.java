package br.com.modules.hexagonal.application.port.in;

public interface RefundPaymentInputPort {
    void refund(String paymentId);
}
