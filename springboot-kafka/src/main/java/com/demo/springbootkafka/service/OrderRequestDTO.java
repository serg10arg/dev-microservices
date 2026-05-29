package com.demo.springbootkafka.service;

public class OrderRequestDTO {
    private String orderId;
    // Se pueden añadir más campos propios de la solicitud de la orden (e.g., userId, items, total)

    public OrderRequestDTO() {}

    public OrderRequestDTO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}