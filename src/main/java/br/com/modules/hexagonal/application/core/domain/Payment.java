package br.com.modules.hexagonal.application.core.domain;

import java.math.BigDecimal;

public class Payment {

    private String paymentId;
    private BigDecimal amount;
    private PaymentStatus status;
    private String orderId;
    private PaymentMethod method;

    public Payment(String paymentId, BigDecimal amount, PaymentStatus status, String orderId, PaymentMethod method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.orderId = orderId;
        this.method = method;
    }

    public Payment() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

}
