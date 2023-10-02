package com.example.coffeeshop.services;

import com.example.coffeeshop.entities.Shop;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import com.example.coffeeshop.repositories.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public Shop getShopById(UUID shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Coffee Shop with uuid: %s does not exist", shopId)));
    }
}
