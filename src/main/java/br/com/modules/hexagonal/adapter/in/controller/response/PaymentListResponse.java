package br.com.modules.hexagonal.adapter.in.controller.response;

import br.com.modules.hexagonal.application.core.domain.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentListResponse {
    List<Payment> paymentList;
    Integer paymentAmount;
}
