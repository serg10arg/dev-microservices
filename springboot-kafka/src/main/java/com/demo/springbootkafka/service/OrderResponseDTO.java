package com.demo.springbootkafka.service;

import java.time.LocalDateTime;

public class OrderResponseDTO {

    private String orderId;
    private String status;
    private String message;
    private LocalDateTime timestamp;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(String orderId, String status, String message, LocalDateTime timestamp) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
