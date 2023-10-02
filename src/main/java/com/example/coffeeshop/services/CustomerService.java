package com.example.coffeeshop.services;

import com.example.coffeeshop.entities.Customer;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import com.example.coffeeshop.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer findCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("could not find customer %s", customerId)));
    }
}
