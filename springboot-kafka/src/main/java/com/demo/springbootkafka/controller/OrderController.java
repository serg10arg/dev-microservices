package com.demo.springbootkafka.controller;

import com.demo.springbootkafka.service.OrderRequestDTO;
import com.demo.springbootkafka.service.OrderResponseDTO;
import com.demo.springbootkafka.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO requestDTO) {
        OrderResponseDTO response = orderService.processOrderCreation(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable String id) {
        OrderResponseDTO response = orderService.getOrderDetails(id);
        return ResponseEntity.ok(response);
    }

}
