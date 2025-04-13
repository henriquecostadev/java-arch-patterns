package br.com.modules.hexagonal.adapter.out.client.handler;

import br.com.modules.hexagonal.adapter.out.client.response.WithdrawBitcoinResponse;

public class WithdrawBitcoinResponseHandler {
    private static final int SUCCESS_CODE = 1;
    private static final int FAILURE_CODE = 2;

    public static boolean handleResponse(WithdrawBitcoinResponse withdrawBitcoinResponse) {
        return switch (withdrawBitcoinResponse.getStatus()) {
            case SUCCESS_CODE -> true;
            case FAILURE_CODE -> false;
            default -> throw new RuntimeException("Failed to withdraw Bitcoins from wallet: "
                    + withdrawBitcoinResponse.getMessage());
        };
    }

}
