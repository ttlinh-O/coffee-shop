package com.example.coffeeshop.services;

import com.example.coffeeshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
}
