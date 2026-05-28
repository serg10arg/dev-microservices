package com.demo.synchasynch.receiver;

import com.demo.synchasynch.config.RabbitConfig;
import com.demo.synchasynch.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    // Indica a Spring que permanezca escuchando la cola configurada
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiverOrder(Order order) {
        // Simulamos un procesamiento en background
        try {
            Thread.sleep(50);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Received Order de manera asincrona: " + order);
    }
}
