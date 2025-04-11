package br.com.modules.hexagonal.adapter.out.client.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizeCreditCardResponse {
    private int status;
    private String message;
}
