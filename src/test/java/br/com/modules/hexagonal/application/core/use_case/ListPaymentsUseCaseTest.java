package br.com.modules.hexagonal.application.core.use_case;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.ports.out.SelectAllPaymentsOutputPort;
import br.com.modules.hexagonal.fixtures.PaymentFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

@QuarkusTest
class ListPaymentsUseCaseTest {

    private ListPaymentsUseCase listPaymentsUseCase;

    @BeforeEach
    void setUp() {
        SelectAllPaymentsOutputPort selectAllPaymentsOutputPort = Mockito.mock(SelectAllPaymentsOutputPort.class);
        this.listPaymentsUseCase = new ListPaymentsUseCase(selectAllPaymentsOutputPort);
    }

    @Test
    void list_shouldListAllPayments() {
        // Given
        List<Payment> paymentsList = List.of(PaymentFixture.getPayment(), PaymentFixture.getPayment());

        // When
        Mockito.when(listPaymentsUseCase.list()).thenReturn(paymentsList);

        // Act
        var returnedList = listPaymentsUseCase.list();

        // Assert
        Assertions.assertEquals(2, returnedList.size());
    }

}
