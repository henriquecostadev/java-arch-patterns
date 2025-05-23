package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.port.in.FindPaymentByIdInputPort;
import br.com.modules.hexagonal.application.port.out.UpdatePaymentOutputPort;
import br.com.modules.hexagonal.fixture.PaymentFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@QuarkusTest
class RefundPaymentUseCaseTest {

    private FindPaymentByIdInputPort findPaymentByIdInputPort;
    private UpdatePaymentOutputPort updatePaymentOutputPort;
    private RefundPaymentUseCase refundPaymentUseCase;

    @BeforeEach
    void setUp() {
        this.findPaymentByIdInputPort = Mockito.mock(FindPaymentByIdInputPort.class);
        this.updatePaymentOutputPort = Mockito.mock(UpdatePaymentOutputPort.class);
        this.refundPaymentUseCase = new RefundPaymentUseCase(findPaymentByIdInputPort, updatePaymentOutputPort);
    }

    @Test
    void refund_shouldUpdatePaymentStatusToRefunded() {
        // Given
        Payment payment = PaymentFixture.getPayment();

        // When
        Mockito.when(findPaymentByIdInputPort.find(payment.getPaymentId())).thenReturn(payment);

        // Act
        refundPaymentUseCase.refund(payment.getPaymentId());

        // Assert
        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        Mockito.verify(updatePaymentOutputPort, Mockito.times(1)).update(paymentCaptor.capture());
        Payment updatedPayment = paymentCaptor.getValue();
        Assertions.assertEquals(PaymentStatus.REFUNDED, updatedPayment.getStatus());
    }

    @Test
    void refund_shouldThrowExceptionWhenPaymentNotFound() {
        // Given
        String paymentId = "nonexistent-id";
        Mockito.when(findPaymentByIdInputPort.find(paymentId)).thenReturn(null);

        // When & Then
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            refundPaymentUseCase.refund(paymentId);
        });

        Assertions.assertEquals("Payment not found with id: " + paymentId, exception.getMessage());
    }

}
