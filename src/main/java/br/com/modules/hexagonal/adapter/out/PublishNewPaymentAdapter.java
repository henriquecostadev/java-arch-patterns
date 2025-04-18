package br.com.modules.hexagonal.adapter.out;

import br.com.modules.hexagonal.application.core.domain.Payment;
import br.com.modules.hexagonal.application.port.out.PublishNewPaymentOutputPort;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class PublishNewPaymentAdapter implements PublishNewPaymentOutputPort {

    @Override
    public void publish(Payment payment) {
        Log.info("Payment published: " + payment.getPaymentId() + " " + payment.getMethod());
    }

}
