package com.example.coffeeshop.services;

import com.example.coffeeshop.entities.Payment;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import com.example.coffeeshop.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment findPaymentById(UUID paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Cannot find payment %s", paymentId)));
    }
}
