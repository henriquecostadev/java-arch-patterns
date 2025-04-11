package br.com.modules.hexagonal.adapter.out.client;

import br.com.modules.hexagonal.adapter.out.client.request.AuthorizeCreditCardRequest;
import br.com.modules.hexagonal.adapter.out.client.response.AuthorizeCreditCardResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/credit-card")
@RegisterRestClient
public interface AuthorizeCreditCardClient {

    @POST
    @Path("/authorize")
    AuthorizeCreditCardResponse authorize(AuthorizeCreditCardRequest authorizeCreditCardRequest);

}
