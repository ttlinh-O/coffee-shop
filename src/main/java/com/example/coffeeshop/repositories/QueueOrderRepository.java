package com.example.coffeeshop.repositories;

import com.example.coffeeshop.entities.QueueOrder;
import com.example.coffeeshop.entities.QueueOrderEmbeddedKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueOrderRepository extends JpaRepository<QueueOrder, QueueOrderEmbeddedKey> {
}
