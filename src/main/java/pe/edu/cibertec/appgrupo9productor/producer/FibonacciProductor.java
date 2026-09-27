package pe.edu.cibertec.appgrupo9productor.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appgrupo9productor.config.RabbitMqConfig;

@Service
public class FibonacciProductor {

    private final RabbitTemplate rabbitTemplate;

    public FibonacciProductor(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarNumerosARabbitMQ(String numbers) {
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE,
                RabbitMqConfig.ROUTING_KEY,
                numbers
        );

        System.out.println("Enviando números a RabbitMQ: " + numbers);
    }
}