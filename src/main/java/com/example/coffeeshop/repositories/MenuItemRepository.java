package com.example.coffeeshop.repositories;

import com.example.coffeeshop.entities.MenuItem;
import com.example.coffeeshop.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuItemRepository extends BaseRepository<MenuItem> {
    List<MenuItem> findAllByIdIn(List<UUID> itemIds);
}
