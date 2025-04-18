package br.com.modules.hexagonal.adapter.in.controller;

import br.com.modules.hexagonal.adapter.in.controller.mapper.CreditCardAuthorizationMapper;
import br.com.modules.hexagonal.adapter.in.controller.request.BitcoinWithdrawRequest;
import br.com.modules.hexagonal.adapter.in.controller.request.CreditCardAuthorizationRequest;
import br.com.modules.hexagonal.adapter.in.controller.response.PaymentListResponse;
import br.com.modules.hexagonal.application.core.domain.CreditCard;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.core.use_case.CreateBitcoinPaymentUseCase;
import br.com.modules.hexagonal.application.core.use_case.CreateCreditCardPaymentUseCase;
import br.com.modules.hexagonal.application.core.use_case.FindPaymentByIdUseCase;
import br.com.modules.hexagonal.application.core.use_case.ListPaymentUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("/v1/payment")
@RequestScoped
public class PaymentController {

    @Inject
    FindPaymentByIdUseCase findPaymentByIdUseCase;

    @Inject
    ListPaymentUseCase listPaymentUseCase;

    @Inject
    CreateCreditCardPaymentUseCase createCreditCardPaymentUseCase;

    @Inject
    CreditCardAuthorizationMapper creditCardAuthorizationMapper;

    @Inject
    CreateBitcoinPaymentUseCase createBitcoinPaymentUseCase;

    @GET
    @Path("/{paymentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPaymentById(@PathParam("paymentId") String paymentId) {

        Payment payment = findPaymentByIdUseCase.find(paymentId);

        if (payment == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Payment " + paymentId + " not found")
                    .build();
        }

        return Response.ok(payment).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPayments() {

        List<Payment> payments = listPaymentUseCase.list();

        if (payments.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No payments found")
                    .build();
        }
        PaymentListResponse paymentListResponse = new PaymentListResponse();
        paymentListResponse.setPaymentList(payments);
        paymentListResponse.setPaymentAmount(payments.size());

        return Response.ok(paymentListResponse).build();
    }

    @POST
    @Path("/credit-card")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCreditCardPayment(CreditCardAuthorizationRequest request) {

        Payment payment = creditCardAuthorizationMapper.toPayment(request);
        CreditCard creditCard = creditCardAuthorizationMapper.toCreditCard(request.getCreditCard());

        String paymentId = createCreditCardPaymentUseCase.create(payment, creditCard);

        URI location = UriBuilder.fromPath("http://localhost:8080/v1/payment/{id}")
                .resolveTemplate("id", paymentId)
                .build();

        return Response.created(location).build();
    }

    @POST
    @Path("/bitcoin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBitcoinPayment(BitcoinWithdrawRequest request) {

        Payment payment = creditCardAuthorizationMapper.toPayment(request);
        String paymentId = createBitcoinPaymentUseCase.create(payment, request.getWalletId());

        URI location = UriBuilder.fromPath("http://localhost:8080/v1/payment/{id}")
                .resolveTemplate("id", paymentId)
                .build();

        return Response.created(location).build();
    }

}
