package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.out.*;
import br.com.modules.hexagonal.fixture.CreditCardFixture;
import br.com.modules.hexagonal.fixture.PaymentFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateCreditCardPaymentUseCaseTest {

    private InsertPaymentOutputPort insertPaymentOutputPort;
    private AuthorizeCreditCardOutputPort authorizeCreditCardOutputPort;
    private UpdatePaymentOutputPort updatePaymentOutputPort;
    private PublishNewPaymentOutputPort publishNewPaymentOutputPort;
    private CreateCreditCardPaymentUseCase createCreditCardPaymentUseCase;

    @BeforeEach
    void setUp() {
        insertPaymentOutputPort = mock(InsertPaymentOutputPort.class);
        authorizeCreditCardOutputPort = mock(AuthorizeCreditCardOutputPort.class);
        updatePaymentOutputPort = mock(UpdatePaymentOutputPort.class);
        publishNewPaymentOutputPort = mock(PublishNewPaymentOutputPort.class);
        createCreditCardPaymentUseCase = new CreateCreditCardPaymentUseCase(
                insertPaymentOutputPort,
                authorizeCreditCardOutputPort,
                updatePaymentOutputPort,
                publishNewPaymentOutputPort
        );
    }

    @Test
    void create_shouldUpdatePaymentStatusToCompletedWhenTransactionIsSuccessful() {
        // Given
        Payment payment = PaymentFixture.getPayment();
        CreditCard creditCard = CreditCardFixture.getCreditCard();

        // When
        when(authorizeCreditCardOutputPort.autorize(creditCard, payment.getAmount())).thenReturn(true);

        // Act
        createCreditCardPaymentUseCase.create(payment, creditCard);

        // Assert
        assertEquals(PaymentStatus.COMPLETED, payment.getStatus());
        verify(insertPaymentOutputPort, times(1)).insert(payment);
        verify(updatePaymentOutputPort, times(1)).update(payment);
        verify(publishNewPaymentOutputPort, times(1)).publish(payment);
    }

    @Test
    void create_shouldUpdatePaymentStatusToFailedWhenTransactionFails() {
        // Given
        Payment payment = PaymentFixture.getPayment();
        CreditCard creditCard = CreditCardFixture.getCreditCard();

        // When
        when(authorizeCreditCardOutputPort.autorize(creditCard, payment.getAmount())).thenReturn(false);

        // Act
        createCreditCardPaymentUseCase.create(payment, creditCard);

        // Assert
        assertEquals(PaymentStatus.FAILED, payment.getStatus());
        verify(insertPaymentOutputPort, times(1)).insert(payment);
        verify(updatePaymentOutputPort, times(1)).update(payment);
        verify(publishNewPaymentOutputPort, never()).publish(payment);
    }
}