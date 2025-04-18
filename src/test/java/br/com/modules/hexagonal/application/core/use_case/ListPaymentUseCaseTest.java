package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.SelectAllPaymentsOutputPort;
import br.com.modules.hexagonal.fixture.PaymentFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

@QuarkusTest
class ListPaymentUseCaseTest {

    private ListPaymentUseCase listPaymentUseCase;

    @BeforeEach
    void setUp() {
        SelectAllPaymentsOutputPort selectAllPaymentsOutputPort = Mockito.mock(SelectAllPaymentsOutputPort.class);
        this.listPaymentUseCase = new ListPaymentUseCase(selectAllPaymentsOutputPort);
    }

    @Test
    void list_shouldListAllPayments() {
        // Given
        List<Payment> paymentsList = List.of(PaymentFixture.getPayment(), PaymentFixture.getPayment());

        // When
        Mockito.when(listPaymentUseCase.list()).thenReturn(paymentsList);

        // Act
        var returnedList = listPaymentUseCase.list();

        // Assert
        Assertions.assertEquals(2, returnedList.size());
    }

}
