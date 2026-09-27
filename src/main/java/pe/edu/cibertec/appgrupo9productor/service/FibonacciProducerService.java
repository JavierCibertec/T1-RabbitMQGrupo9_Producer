package pe.edu.cibertec.appgrupo9productor.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.appgrupo9productor.producer.FibonacciProductor;

@Service
public class FibonacciProducerService {

    private final FibonacciProductor fibonacciProductor;

    public FibonacciProducerService(FibonacciProductor fibonacciProductor) {
        this.fibonacciProductor = fibonacciProductor;
    }

    public void enviarLista(String numbers) {
        fibonacciProductor.enviarNumerosARabbitMQ(numbers);
    }
}