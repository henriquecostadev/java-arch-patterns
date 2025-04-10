package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.ports.out.SelectPaymentByIdOutputPort;
import br.com.modules.hexagonal.fixtures.PaymentFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class FindPaymentByIdUseCaseTest {

    private SelectPaymentByIdOutputPort selectPaymentByIdOutputPort;
    private FindPaymentByIdUseCase findPaymentByIdUseCase;

    @BeforeEach
    void setUp() {
        this.selectPaymentByIdOutputPort = Mockito.mock(SelectPaymentByIdOutputPort.class);
        this.findPaymentByIdUseCase = new FindPaymentByIdUseCase(selectPaymentByIdOutputPort);
    }

    @Test
    void find_shouldReturnPayment() {
        // Given
        Payment payment = PaymentFixture.getPayment();

        // When
        Mockito.when(selectPaymentByIdOutputPort.select(payment.getPaymentId())).thenReturn(payment);

        // Act
        Payment foundPayment = findPaymentByIdUseCase.find(payment.getPaymentId());

        // Assert
        Assertions.assertNotNull(foundPayment);
        Assertions.assertEquals(payment.getPaymentId(), foundPayment.getPaymentId());
    }
}