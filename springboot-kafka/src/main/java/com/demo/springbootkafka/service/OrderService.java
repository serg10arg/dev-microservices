package com.demo.springbootkafka.service;

import com.demo.springbootkafka.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private static final String TOPIC = "orders";

    public OrderService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public OrderResponseDTO processOrderCreation(OrderRequestDTO requestDTO) {
        String id = requestDTO.getOrderId();
        OrderEvent event = new OrderEvent(id, "CREATED");
        kafkaTemplate.send(TOPIC, id, event);

        return new OrderResponseDTO(
                id,
                "CREATED",
                "El procesamiento asincrono de la orden ha sido iniciado correctamente",
                LocalDateTime.now()
        );
    }

    public OrderResponseDTO getOrderDetails(String id) {
        return new OrderResponseDTO(
                id,
                "PROCESSED",
                "Detalles de la orden recuperados desde el almacen de datos.",
                LocalDateTime.now()
        );
    }
}
