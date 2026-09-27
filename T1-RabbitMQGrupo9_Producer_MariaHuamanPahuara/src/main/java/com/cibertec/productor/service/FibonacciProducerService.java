package com.cibertec.productor.service;

import com.cibertec.productor.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FibonacciProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public FibonacciProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // se manda el string como viene ("1;2;15;8"), el consumidor lo separa
    public void sendNumbers(String numbersRaw) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                numbersRaw
        );
    }
}
