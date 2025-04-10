package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.in.RefundPaymentInputPort;
import br.com.modules.hexagonal.application.port.out.SelectPaymentByIdOutputPort;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;

public class RefundPaymentUseCase implements RefundPaymentInputPort {

    private final SelectPaymentByIdOutputPort selectPaymentByIdOutputPort;
    private final UpdatePaymentOutputPort updatePaymentOutputPort;

    public RefundPaymentUseCase(
            SelectPaymentByIdOutputPort selectPaymentByIdOutputPort,
            UpdatePaymentOutputPort updatePaymentOutputPort) {
        this.selectPaymentByIdOutputPort = selectPaymentByIdOutputPort;
        this.updatePaymentOutputPort = updatePaymentOutputPort;
    }

    @Override
    public void refund(String paymentId) {
        Payment payment = selectPaymentByIdOutputPort.select(paymentId);
        payment.setStatus(PaymentStatus.REFUNDED);
        updatePaymentOutputPort.update(payment);
    }

}
