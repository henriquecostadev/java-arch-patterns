package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.repository.PaymentRepository;
import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import br.com.modules.hexagonal.adapter.out.repository.mapper.PaymentEntityMapper;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class UpdatePaymentAdapter implements UpdatePaymentOutputPort {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentEntityMapper paymentEntityMapper;

    @Override
    public void update(Payment payment) {
        PaymentEntity paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.update(paymentEntity);
    }
}
