package br.com.modules.hexagonal.adapter.out.repository.mapper;

import br.com.modules.hexagonal.adapter.out.repository.entity.PaymentEntity;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface PaymentEntityMapper {
    PaymentEntity toPaymentEntity(Payment payment);

    Payment toPayment(PaymentEntity paymentEntity);
}
