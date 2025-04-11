package br.com.modules.hexagonal.adapter.out.client.handler;

import br.com.modules.hexagonal.adapter.out.client.response.AuthorizeCreditCardResponse;

public class AuthorizeCreditCardResponseHandler {
    private static final int SUCCESS_CODE = 1;
    private static final int FAILURE_CODE = 2;

    public static boolean handleResponse(AuthorizeCreditCardResponse authorizeCreditCardResponse) {
        return switch (authorizeCreditCardResponse.getStatus()) {
            case SUCCESS_CODE -> true;
            case FAILURE_CODE -> false;
            default ->
                    throw new RuntimeException("Failed to authorize credit card: " + authorizeCreditCardResponse.getMessage());
        };
    }

}
