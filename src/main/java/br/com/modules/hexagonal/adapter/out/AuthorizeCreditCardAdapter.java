package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.client.AuthorizeCreditCardClient;
import br.com.modules.hexagonal.adapter.out.client.mapper.AuthorizeCreditCardMapper;
import br.com.modules.hexagonal.adapter.out.client.request.AuthorizeCreditCardRequest;
import br.com.modules.hexagonal.adapter.out.client.response.AuthorizeCreditCardResponse;
import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.port.out.AuthorizeCreditCardOutputPort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

import static br.com.modules.hexagonal.adapter.out.client.handler.AuthorizeCreditCardResponseHandler.handleResponse;

@RequestScoped
public class AuthorizeCreditCardAdapter implements AuthorizeCreditCardOutputPort {

    @RestClient
    private AuthorizeCreditCardClient authorizeCreditCardClient;

    @Inject
    private AuthorizeCreditCardMapper authorizeCreditCardMapper;

    @Override
    public boolean authorize(CreditCard creditCard, BigDecimal amount) {
        AuthorizeCreditCardRequest request = authorizeCreditCardMapper.toRequest(creditCard, amount);
        AuthorizeCreditCardResponse response = authorizeCreditCardClient.authorize(request);
        return handleResponse(response);
    }

}
