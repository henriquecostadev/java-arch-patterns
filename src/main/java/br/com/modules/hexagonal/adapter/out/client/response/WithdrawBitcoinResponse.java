package br.com.modules.hexagonal.adapter.out.client.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawBitcoinResponse {
    private int status;
    private String message;
}
