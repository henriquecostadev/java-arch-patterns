package br.com.modules.hexagonal.adapter.out.mapper;

import br.com.modules.hexagonal.adapter.out.message.PaymentMessage;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface PaymentMessageMapper {
    PaymentMessage toPaymentMessage(Payment payment);
}
