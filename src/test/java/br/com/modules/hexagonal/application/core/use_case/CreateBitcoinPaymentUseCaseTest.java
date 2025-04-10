package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.out.InsertPaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.PublishNewPaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;
import br.com.modules.hexagonal.application.port.out.WithdrawBitcoinOutputPort;
import br.com.modules.hexagonal.fixture.PaymentFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateBitcoinPaymentUseCaseTest {

    private InsertPaymentOutputPort insertPaymentOutputPort;
    private WithdrawBitcoinOutputPort withdrawBitcoinOutputPort;
    private UpdatePaymentOutputPort updatePaymentOutputPort;
    private PublishNewPaymentOutputPort publishNewPaymentOutputPort;
    private CreateBitcoinPaymentUseCase createBitcoinPaymentUseCase;

    @BeforeEach
    void setUp() {
        insertPaymentOutputPort = mock(InsertPaymentOutputPort.class);
        withdrawBitcoinOutputPort = mock(WithdrawBitcoinOutputPort.class);
        updatePaymentOutputPort = mock(UpdatePaymentOutputPort.class);
        publishNewPaymentOutputPort = mock(PublishNewPaymentOutputPort.class);
        createBitcoinPaymentUseCase = new CreateBitcoinPaymentUseCase(
                insertPaymentOutputPort,
                withdrawBitcoinOutputPort,
                updatePaymentOutputPort,
                publishNewPaymentOutputPort
        );
    }

    @Test
    void create_shouldUpdatePaymentStatusToCompletedWhenTransactionIsSuccessful() {
        // Given
        Payment payment = PaymentFixture.getPayment();
        String walletId = "wallet123";

        // When
        when(withdrawBitcoinOutputPort.withdraw(walletId, payment.getAmount())).thenReturn(true);

        // Act
        createBitcoinPaymentUseCase.create(payment, walletId);

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
        String walletId = "wallet123";

        // When
        when(withdrawBitcoinOutputPort.withdraw(walletId, payment.getAmount())).thenReturn(false);

        // Act
        createBitcoinPaymentUseCase.create(payment, walletId);

        // Assert
        assertEquals(PaymentStatus.FAILED, payment.getStatus());
        verify(insertPaymentOutputPort, times(1)).insert(payment);
        verify(updatePaymentOutputPort, times(1)).update(payment);
        verify(publishNewPaymentOutputPort, never()).publish(payment);
    }
}