package br.com.modules.hexagonal.fixture;

import br.com.modules.hexagonal.adapter.out.client.response.WithdrawBitcoinResponse;

public class WithdrawBitcoinResponseFixture {
    public static WithdrawBitcoinResponse getSucessWithdrawBitcoinResponse() {
        var withdrawBitcoinResponse = new WithdrawBitcoinResponse();
        withdrawBitcoinResponse.setStatus(1);
        withdrawBitcoinResponse.setMessage("Success");
        return withdrawBitcoinResponse;
    }

    public static WithdrawBitcoinResponse getRejectedAuthorizeCreditCardResponse() {
        var withdrawBitcoinResponse = new WithdrawBitcoinResponse();
        withdrawBitcoinResponse.setStatus(2);
        withdrawBitcoinResponse.setMessage("Rejected");
        return withdrawBitcoinResponse;
    }
}
