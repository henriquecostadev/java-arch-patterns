package br.com.modules.hexagonal.adapter.in.controller.mapper;

import br.com.modules.hexagonal.adapter.in.controller.request.BitcoinWithdrawRequest;
import br.com.modules.hexagonal.adapter.in.controller.request.CreditCardAuthorizationRequest;
import br.com.modules.hexagonal.adapter.in.controller.request.CreditCardRequest;
import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = QuarkusMappingConfig.class)
public interface CreditCardAuthorizationMapper {

    @Mapping(target = "paymentId", ignore = true)
    @Mapping(target = "method", ignore = true)
    @Mapping(target = "status", ignore = true)
    Payment toPayment(CreditCardAuthorizationRequest request);

    @Mapping(target = "paymentId", ignore = true)
    @Mapping(target = "method", ignore = true)
    @Mapping(target = "status", ignore = true)
    Payment toPayment(BitcoinWithdrawRequest request);

    CreditCard toCreditCard(CreditCardRequest request);
}
