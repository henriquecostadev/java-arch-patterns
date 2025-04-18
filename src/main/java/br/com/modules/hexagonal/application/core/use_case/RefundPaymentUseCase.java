package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.in.FindPaymentByIdInputPort;
import br.com.modules.hexagonal.application.port.in.RefundPaymentInputPort;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;

public class RefundPaymentUseCase implements RefundPaymentInputPort {

    private final FindPaymentByIdInputPort findPaymentByIdInputPort;
    private final UpdatePaymentOutputPort updatePaymentOutputPort;

    public RefundPaymentUseCase(
            FindPaymentByIdInputPort findPaymentByIdInputPort,
            UpdatePaymentOutputPort updatePaymentOutputPort) {
        this.findPaymentByIdInputPort = findPaymentByIdInputPort;
        this.updatePaymentOutputPort = updatePaymentOutputPort;
    }

    @Override
    public void refund(String paymentId) {
        Payment payment = findPaymentByIdInputPort.find(paymentId);

        if (payment == null)
            throw new RuntimeException("Payment not found with id: " + paymentId);

        payment.setStatus(PaymentStatus.REFUNDED);
        updatePaymentOutputPort.update(payment);
    }

}
