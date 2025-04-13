package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.client.WithdrawBitcoinClient;
import br.com.modules.hexagonal.adapter.out.client.mapper.WithdrawBitcoinMapper;
import br.com.modules.hexagonal.adapter.out.client.request.WithdrawBitcoinRequest;
import br.com.modules.hexagonal.fixture.WithdrawBitcoinResponseFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class WithdrawBitcoinAdapterTest {

    @Mock
    private WithdrawBitcoinClient WithdrawBitcoinClient;

    @Mock
    private WithdrawBitcoinMapper WithdrawBitcoinMapper;

    @InjectMocks
    private WithdrawBitcoinAdapter WithdrawBitcoinAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldWithdrawBitcoinPayment() {
        // Given
        var walletId = "123";
        var amount = BigDecimal.valueOf(100.00);
        var request = new WithdrawBitcoinRequest();
        var response = WithdrawBitcoinResponseFixture.getSucessWithdrawBitcoinResponse();

        // Mock
        Mockito.when(WithdrawBitcoinMapper.toRequest(walletId, amount)).thenReturn(request);
        Mockito.when(WithdrawBitcoinClient.withdraw(request)).thenReturn(response);

        // Act
        var result = WithdrawBitcoinAdapter.withdraw(walletId, amount);

        // Assert
        assertTrue(result);
    }
}