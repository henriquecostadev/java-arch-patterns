package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentMethod;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.in.CreateCreditCardPaymentInputPort;
import br.com.modules.hexagonal.application.port.out.*;

public class CreateCreditCardPaymentUseCase implements CreateCreditCardPaymentInputPort {

    private final InsertPaymentOutputPort insertPaymentOutputPort;
    private final AuthorizeCreditCardOutputPort authorizeCreditCardOutputPort;
    private final UpdatePaymentOutputPort updatePaymentOutputPort;
    private final PublishNewPaymentOutputPort publishNewPaymentOutputPort;

    public CreateCreditCardPaymentUseCase(
            InsertPaymentOutputPort insertPaymentOutputPort,
            AuthorizeCreditCardOutputPort authorizeCreditCardOutputPort,
            UpdatePaymentOutputPort updatePaymentOutputPort,
            PublishNewPaymentOutputPort publishNewPaymentOutputPort
    ) {
        this.insertPaymentOutputPort = insertPaymentOutputPort;
        this.authorizeCreditCardOutputPort = authorizeCreditCardOutputPort;
        this.updatePaymentOutputPort = updatePaymentOutputPort;
        this.publishNewPaymentOutputPort = publishNewPaymentOutputPort;
    }

    // Example of Single Responsiblity Principle (SRP) x DRY Principle and KISS Principle problem
    @Override
    public void create(Payment payment, CreditCard creditCard) {
        payment.setMethod(PaymentMethod.CREDIT_CARD);
        payment.setStatus(PaymentStatus.PENDING);
        insertPaymentOutputPort.insert(payment);

        boolean isTransactionSuccessful = authorizeCreditCardOutputPort.authorize(creditCard, payment.getAmount());

        payment.setStatus(isTransactionSuccessful ? PaymentStatus.COMPLETED : PaymentStatus.FAILED);
        updatePaymentOutputPort.update(payment);

        if (isTransactionSuccessful) {
            publishNewPaymentOutputPort.publish(payment);
        }
    }
}
