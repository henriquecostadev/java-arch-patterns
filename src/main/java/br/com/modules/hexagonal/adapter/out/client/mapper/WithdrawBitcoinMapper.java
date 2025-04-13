package br.com.modules.hexagonal.adapter.out.client.mapper;

import br.com.modules.hexagonal.adapter.out.client.request.WithdrawBitcoinRequest;
import br.com.modules.hexagonal.config.QuarkusMappingConfig;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(config = QuarkusMappingConfig.class)
public interface WithdrawBitcoinMapper {
    WithdrawBitcoinRequest toRequest(String walletId, BigDecimal amount);
}
