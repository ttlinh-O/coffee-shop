package com.example.coffeeshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String test() {
        return "Hello";
    }

    @PostMapping
    public UUID createOrder() {
        return UUID.randomUUID();
    }
}
