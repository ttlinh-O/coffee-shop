package com.example.coffeeshop.controllers;

import com.example.coffeeshop.dtos.OrderRequestDTO;
import com.example.coffeeshop.dtos.OrderResponseDTO;
import com.example.coffeeshop.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
