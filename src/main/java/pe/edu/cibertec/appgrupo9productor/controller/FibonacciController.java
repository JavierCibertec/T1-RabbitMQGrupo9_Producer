package pe.edu.cibertec.appgrupo9productor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.appgrupo9productor.service.FibonacciProducerService;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final FibonacciProducerService fibonacciProducerService;

    public FibonacciController(FibonacciProducerService fibonacciProducerService) {
        this.fibonacciProducerService = fibonacciProducerService;
    }

    @GetMapping("/send")
    public String send(@RequestParam("numbers") String numbers) {
        fibonacciProducerService.enviarLista(numbers);
        return "Lista enviada a RabbitMQ correctamente.";
    }
}