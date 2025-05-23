package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentMethod;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.in.CreateBitcoinPaymentInputPort;
import br.com.modules.hexagonal.application.port.out.InsertPaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.PublishNewPaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.WithdrawBitcoinOutputPort;

public class CreateBitcoinPaymentUseCase implements CreateBitcoinPaymentInputPort {

    private final InsertPaymentOutputPort insertPaymentOutputPort;
    private final WithdrawBitcoinOutputPort withdrawBitcoinOutputPort;
    private final UpdatePaymentOutputPort updatePaymentOutputPort;
    private final PublishNewPaymentOutputPort publishNewPaymentOutputPort;

    public CreateBitcoinPaymentUseCase(
            InsertPaymentOutputPort insertPaymentOutputPort,
            WithdrawBitcoinOutputPort withdrawBitcoinOutputPort,
            UpdatePaymentOutputPort updatePaymentOutputPort,
            PublishNewPaymentOutputPort publishNewPaymentOutputPort
    ) {
        this.insertPaymentOutputPort = insertPaymentOutputPort;
        this.withdrawBitcoinOutputPort = withdrawBitcoinOutputPort;
        this.updatePaymentOutputPort = updatePaymentOutputPort;
        this.publishNewPaymentOutputPort = publishNewPaymentOutputPort;
    }

    // Example of Single Responsiblity Principle (SRP) x DRY Principle and KISS Principle problem
    @Override
    public String create(Payment payment, String walletId) {
        payment.setMethod(PaymentMethod.BITCOIN);
        payment.setStatus(PaymentStatus.PENDING);

        String paymentId = insertPaymentOutputPort.insert(payment);
        payment.setPaymentId(paymentId);

        boolean isTransactionSuccessful = withdrawBitcoinOutputPort.withdraw(walletId, payment.getAmount());

        payment.setStatus(isTransactionSuccessful ? PaymentStatus.COMPLETED : PaymentStatus.FAILED);
        updatePaymentOutputPort.update(payment);

        if (isTransactionSuccessful) {
            publishNewPaymentOutputPort.publish(payment);
        }

        return paymentId;
    }
}
