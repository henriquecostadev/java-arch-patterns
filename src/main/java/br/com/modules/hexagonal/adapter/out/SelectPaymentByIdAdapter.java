package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.repository.PaymentRepository;
import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import br.com.modules.hexagonal.adapter.out.repository.mapper.PaymentEntityMapper;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.SelectPaymentByIdOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class SelectPaymentByIdAdapter implements SelectPaymentByIdOutputPort {

    @Inject
    private PaymentRepository paymentRepository;

    @Inject
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public Payment select(String paymentId) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId);
        return paymentEntityMapper.toPayment(paymentEntity);
    }

}
