package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.client.AuthorizeCreditCardClient;
import br.com.modules.hexagonal.adapter.out.client.mapper.AuthorizeCreditCardMapper;
import br.com.modules.hexagonal.adapter.out.client.request.AuthorizeCreditCardRequest;
import br.com.modules.hexagonal.fixture.AuthorizeCreditCardResponseFixture;
import br.com.modules.hexagonal.fixture.CreditCardFixture;
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
class AuthorizeCreditCardAdapterTest {

    @Mock
    private AuthorizeCreditCardClient authorizeCreditCardClient;

    @Mock
    private AuthorizeCreditCardMapper authorizeCreditCardMapper;

    @InjectMocks
    private AuthorizeCreditCardAdapter authorizeCreditCardAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAuthorizeCreditCardPayment() {
        // Given
        var creditCard = CreditCardFixture.getCreditCard();
        var amount = BigDecimal.valueOf(100.00);
        var request = new AuthorizeCreditCardRequest();
        var response = AuthorizeCreditCardResponseFixture.getSucessAuthorizeCreditCardResponse();

        // Mock
        Mockito.when(authorizeCreditCardMapper.toRequest(creditCard, amount)).thenReturn(request);
        Mockito.when(authorizeCreditCardClient.authorize(request)).thenReturn(response);

        // Act
        var result = authorizeCreditCardAdapter.authorize(creditCard, amount);

        // Assert
        assertTrue(result);
    }
}