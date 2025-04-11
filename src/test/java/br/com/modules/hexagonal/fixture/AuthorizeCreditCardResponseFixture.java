package br.com.modules.hexagonal.fixture;

import br.com.modules.hexagonal.adapter.out.client.response.AuthorizeCreditCardResponse;

public class AuthorizeCreditCardResponseFixture {
    public static AuthorizeCreditCardResponse getSucessAuthorizeCreditCardResponse() {
        var authorizeCreditCardResponse = new AuthorizeCreditCardResponse();
        authorizeCreditCardResponse.setStatus(1);
        authorizeCreditCardResponse.setMessage("Success");
        return authorizeCreditCardResponse;
    }

    public static AuthorizeCreditCardResponse getRejectedAuthorizeCreditCardResponse() {
        var authorizeCreditCardResponse = new AuthorizeCreditCardResponse();
        authorizeCreditCardResponse.setStatus(2);
        authorizeCreditCardResponse.setMessage("Rejected");
        return authorizeCreditCardResponse;
    }
}
