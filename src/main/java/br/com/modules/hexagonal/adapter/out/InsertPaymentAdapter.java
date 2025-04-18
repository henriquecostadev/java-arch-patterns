package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.repository.PaymentRepository;
import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import br.com.modules.hexagonal.adapter.out.repository.mapper.PaymentEntityMapper;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.InsertPaymentOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class InsertPaymentAdapter implements InsertPaymentOutputPort {

    @Inject
    private PaymentRepository paymentRepository;

    @Inject
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public String insert(Payment payment) {
        PaymentEntity paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        String paymentId = paymentRepository.insert(paymentEntity);
        return paymentEntity.getPaymentId();
    }

}
