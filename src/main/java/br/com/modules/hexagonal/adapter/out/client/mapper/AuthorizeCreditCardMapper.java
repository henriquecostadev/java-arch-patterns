package br.com.modules.hexagonal.adapter.out.client.mapper;

import br.com.modules.hexagonal.adapter.out.client.request.AuthorizeCreditCardRequest;
import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(config = QuarkusMappingConfig.class)
public interface AuthorizeCreditCardMapper {
    AuthorizeCreditCardRequest toRequest(CreditCard creditCard, BigDecimal amount);
}
