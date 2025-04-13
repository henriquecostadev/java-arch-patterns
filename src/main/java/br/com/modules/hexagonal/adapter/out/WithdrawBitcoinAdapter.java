package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.client.WithdrawBitcoinClient;
import br.com.modules.hexagonal.adapter.out.client.mapper.WithdrawBitcoinMapper;
import br.com.modules.hexagonal.adapter.out.client.request.WithdrawBitcoinRequest;
import br.com.modules.hexagonal.adapter.out.client.response.WithdrawBitcoinResponse;
import br.com.modules.hexagonal.application.port.out.WithdrawBitcoinOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

import static br.com.modules.hexagonal.adapter.out.client.handler.WithdrawBitcoinResponseHandler.handleResponse;

@RequestScoped
public class WithdrawBitcoinAdapter implements WithdrawBitcoinOutputPort {

    @RestClient
    private WithdrawBitcoinClient withdrawBitcoinClient;

    @Inject
    private WithdrawBitcoinMapper withdrawBitcoinMapper;

    @Override
    public boolean withdraw(String walletId, BigDecimal amount) {
        WithdrawBitcoinRequest request = withdrawBitcoinMapper.toRequest(walletId, amount);
        WithdrawBitcoinResponse response = withdrawBitcoinClient.withdraw(request);
        return handleResponse(response);
    }
}
