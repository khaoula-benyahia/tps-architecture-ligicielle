package com.ecommerce.monolith.order.controller;

import com.ecommerce.monolith.order.dto.OrderRequest;
import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }
}