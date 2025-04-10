package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.ports.in.FindPaymentByIdInputPort;
import br.com.modules.hexagonal.application.ports.out.SelectPaymentByIdOutputPort;

public class FindPaymentByIdUseCase implements FindPaymentByIdInputPort {

    private final SelectPaymentByIdOutputPort selectPaymentByIdOutputPort;

    public FindPaymentByIdUseCase(SelectPaymentByIdOutputPort selectPaymentByIdOutputPort) {
        this.selectPaymentByIdOutputPort = selectPaymentByIdOutputPort;
    }

    @Override
    public Payment find(String paymentId) {
        return selectPaymentByIdOutputPort.select(paymentId);
    }

}
