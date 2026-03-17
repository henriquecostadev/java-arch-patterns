package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.adapter.out.factory.RabbitMqConnectionFactory;
import br.com.modules.hexagonal.adapter.out.mapper.PaymentMessageMapper;
import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.PublishNewPaymentOutputPort;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class PublishNewPaymentAdapter implements PublishNewPaymentOutputPort {

    @Inject
    RabbitMqConnectionFactory rabbitMqConnectionFactory;

    @Inject
    PaymentMessageMapper paymentMessageMapper;

    @Override
    public void publish(Payment payment) {
        Log.info("Sending payment to Rabbit: " + payment.getPaymentId());
        String message = paymentMessageMapper.toPaymentMessage(payment).toString();
        rabbitMqConnectionFactory.publish(message);
    }

}
