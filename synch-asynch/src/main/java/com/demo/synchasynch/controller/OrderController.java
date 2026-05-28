package com.demo.synchasynch.controller;

import com.demo.synchasynch.model.Order;
import com.demo.synchasynch.sender.OrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderSender orderSender;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        //publicamos el mensaje en el broker de forma instantanea
        orderSender.sendOrder(order);

        // respondemos de inmediato al cliente sin esperar a que el receiver procese la orden
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Orden recibida y encolada para su procesamiento asincrono");
    }
}
