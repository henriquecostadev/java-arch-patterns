package br.com.modules.hexagonal.adapter.out.client.handler;

import br.com.modules.hexagonal.adapter.out.client.response.WithdrawBitcoinResponse;
import br.com.modules.hexagonal.fixture.WithdrawBitcoinResponseFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class WithdrawBitcoinResponseHandlerTest {

    @Test
    void shouldReturnTrueForSuccessCode() {
        // Arrange
        WithdrawBitcoinResponse response =
                WithdrawBitcoinResponseFixture.getSucessWithdrawBitcoinResponse();

        // Act
        boolean result = WithdrawBitcoinResponseHandler.handleResponse(response);

        // Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForFailureCode() {
        // Arrange
        WithdrawBitcoinResponse response =
                WithdrawBitcoinResponseFixture.getRejectedAuthorizeCreditCardResponse();

        // Act
        boolean result = WithdrawBitcoinResponseHandler.handleResponse(response);

        // Assert
        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionForUnexpectedStatus() {
        // Arrange
        WithdrawBitcoinResponse response = new WithdrawBitcoinResponse();

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
                WithdrawBitcoinResponseHandler.handleResponse(response)
        );

    }

}