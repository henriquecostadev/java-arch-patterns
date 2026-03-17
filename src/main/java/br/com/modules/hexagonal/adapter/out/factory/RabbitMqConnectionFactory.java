package br.com.modules.hexagonal.adapter.out.factory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import jakarta.enterprise.context.RequestScoped;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RequestScoped
public class RabbitMqConnectionFactory {

    public void publish(String message) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            final String QUEUE_NAME = "payment_queue";
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}
