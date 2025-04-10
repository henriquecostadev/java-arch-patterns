package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.domain.PaymentStatus;
import br.com.modules.hexagonal.application.ports.out.SelectPaymentByIdOutputPort;
import br.com.modules.hexagonal.application.ports.out.UpdatePaymentOutputPort;
import br.com.modules.hexagonal.fixtures.PaymentFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@QuarkusTest
class RefundPaymentUseCaseTest {

    private SelectPaymentByIdOutputPort selectPaymentByIdOutputPort;
    private UpdatePaymentOutputPort updatePaymentOutputPort;
    private RefundPaymentUseCase refundPaymentUseCase;

    @BeforeEach
    void setUp() {
        this.selectPaymentByIdOutputPort = Mockito.mock(SelectPaymentByIdOutputPort.class);
        this.updatePaymentOutputPort = Mockito.mock(UpdatePaymentOutputPort.class);
        this.refundPaymentUseCase = new RefundPaymentUseCase(selectPaymentByIdOutputPort, updatePaymentOutputPort);
    }

    @Test
    void refund_shouldUpdatePaymentStatusToRefunded() {
        // Given
        Payment payment = PaymentFixture.getPayment();

        // When
        Mockito.when(selectPaymentByIdOutputPort.select(payment.getPaymentId())).thenReturn(payment);

        // Act
        refundPaymentUseCase.refund(payment.getPaymentId());

        // Assert
        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        Mockito.verify(updatePaymentOutputPort, Mockito.times(1)).update(paymentCaptor.capture());
        Payment updatedPayment = paymentCaptor.getValue();
        Assertions.assertEquals(PaymentStatus.REFUNDED, updatedPayment.getStatus());
    }

}
