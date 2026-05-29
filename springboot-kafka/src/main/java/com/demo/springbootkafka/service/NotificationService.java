package com.demo.springbootkafka.service;

import com.demo.springbootkafka.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(
            topics = "orders",
            groupId = "order-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(OrderEvent event) {
        System.out.println("--- Evento Consumido Exitosamente ---");
        System.out.println("Procesando notificacion para la orden ID: " + event.getOrderId());
        System.out.println("Estado de la orden: " + event.getOrderStatus());
    }
}
