package com.example.coffeeshop.services;

import com.example.coffeeshop.dtos.OrderItemRequestDTO;
import com.example.coffeeshop.entities.MenuItem;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import com.example.coffeeshop.repositories.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public void validateOrderItems(List<OrderItemRequestDTO> orderItems) {
        List<UUID> itemIds = new ArrayList<>(orderItems.stream().map(OrderItemRequestDTO::getItemId).toList());
        List<UUID> itemIdsFromDB = new ArrayList<>(menuItemRepository.findAllByIdIn(itemIds)
                        .stream().map(MenuItem::getId).toList());
        itemIds.removeAll(itemIdsFromDB);
        if (!CollectionUtils.isEmpty(itemIds)) {
            throw new ResourceNotFoundException(String.format("Can not find menu items: %s", itemIds));
        }
    }
}
