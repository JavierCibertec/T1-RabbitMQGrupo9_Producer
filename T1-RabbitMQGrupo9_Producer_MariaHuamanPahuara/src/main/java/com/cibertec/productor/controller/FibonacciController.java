package com.cibertec.productor.controller;

import com.cibertec.productor.service.FibonacciProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private final FibonacciProducerService producerService;

    @Autowired
    public FibonacciController(FibonacciProducerService producerService) {
        this.producerService = producerService;
    }

    // ej: /api/fibonacci/send?numbers=1;2;15;8
    @GetMapping("/api/fibonacci/send")
    public String sendNumbers(@RequestParam("numbers") String numbers) {
        producerService.sendNumbers(numbers);
        return "Lista enviada a RabbitMQ correctamente.";
    }
}
