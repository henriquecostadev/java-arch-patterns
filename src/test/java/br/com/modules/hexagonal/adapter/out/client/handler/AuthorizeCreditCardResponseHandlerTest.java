package br.com.modules.hexagonal.adapter.out.client.handler;

import br.com.modules.hexagonal.adapter.out.client.response.AuthorizeCreditCardResponse;
import br.com.modules.hexagonal.fixture.AuthorizeCreditCardResponseFixture;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class AuthorizeCreditCardResponseHandlerTest {

    @Test
    void shouldReturnTrueForSuccessCode() {
        // Arrange
        AuthorizeCreditCardResponse response =
                AuthorizeCreditCardResponseFixture.getSucessAuthorizeCreditCardResponse();

        // Act
        boolean result = AuthorizeCreditCardResponseHandler.handleResponse(response);

        // Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForFailureCode() {
        // Arrange
        AuthorizeCreditCardResponse response =
                AuthorizeCreditCardResponseFixture.getRejectedAuthorizeCreditCardResponse();

        // Act
        boolean result = AuthorizeCreditCardResponseHandler.handleResponse(response);

        // Assert
        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionForUnexpectedStatus() {
        // Arrange
        AuthorizeCreditCardResponse response = new AuthorizeCreditCardResponse();

        // Act & Assert
        assertThrows(RuntimeException.class, () ->
                AuthorizeCreditCardResponseHandler.handleResponse(response)
        );

    }
}