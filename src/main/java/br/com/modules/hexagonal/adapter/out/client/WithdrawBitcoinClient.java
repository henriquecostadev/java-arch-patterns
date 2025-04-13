package br.com.modules.hexagonal.adapter.out.client;

import br.com.modules.hexagonal.adapter.out.client.request.WithdrawBitcoinRequest;
import br.com.modules.hexagonal.adapter.out.client.response.WithdrawBitcoinResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/bitcoin")
@RegisterRestClient
public interface WithdrawBitcoinClient {

    @POST
    @Path("/withdraw")
    WithdrawBitcoinResponse withdraw(WithdrawBitcoinRequest withdrawBitcoinRequest);

}
