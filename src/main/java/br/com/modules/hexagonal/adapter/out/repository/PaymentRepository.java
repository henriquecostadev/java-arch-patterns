package br.com.modules.hexagonal.adapter.out.repository;

import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PaymentRepository {

    // Simulating a database with an in-memory list
    private final List<PaymentEntity> paymentEntityList = new ArrayList<>();

    public String insert(PaymentEntity paymentEntity) {
        paymentEntity.setPaymentId(UUID.randomUUID().toString());
        paymentEntityList.add(paymentEntity);
        return paymentEntity.getPaymentId();
    }

    public PaymentEntity findById(String paymentId) {
        return paymentEntityList.stream()
                .filter(payment -> payment.getPaymentId().equals(paymentId))
                .findFirst()
                .orElse(null);
    }

    public List<PaymentEntity> listAll() {
        return paymentEntityList;
    }

    public void update(PaymentEntity paymentEntity) {
        for (PaymentEntity p : paymentEntityList) {
            if (p.getPaymentId().equals(paymentEntity.getPaymentId())) {
                p.setAmount(paymentEntity.getAmount());
                p.setStatus(paymentEntity.getStatus());
                p.setOrderId(paymentEntity.getOrderId());
                p.setMethod(paymentEntity.getMethod());
                break;
            }
        }
    }

}
