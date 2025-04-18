package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.repository.PaymentRepository;
import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import br.com.modules.hexagonal.adapter.out.repository.mapper.PaymentEntityMapper;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.SelectAllPaymentsOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class SelectAllPaymentsAdapter implements SelectAllPaymentsOutputPort {

    @Inject
    private PaymentRepository paymentRepository;

    @Inject
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public List<Payment> selectAll() {

        List<PaymentEntity> paymentEntityList = paymentRepository.listAll();

        return paymentEntityList
                .stream()
                .map(paymentEntity -> paymentEntityMapper.toPayment(paymentEntity))
                .toList();
    }

}
