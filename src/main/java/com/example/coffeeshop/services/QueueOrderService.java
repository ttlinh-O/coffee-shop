package com.example.coffeeshop.services;

import com.example.coffeeshop.dtos.OrderItemRequestDTO;
import com.example.coffeeshop.entities.*;
import com.example.coffeeshop.exceptions.ConflictingDataException;
import com.example.coffeeshop.repositories.QueueOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QueueOrderService {
    private final QueueOrderRepository queueOrderRepository;
    private final QueueService queueService;

    @Transactional
    public QueueOrder saveQueueOrder(Shop shop, Order order) {
        Queue queue = queueService.findNextQueue(shop);
        LocalDateTime expectedWaitingTime = getExpectedWaitingTime(shop.getId());
        Integer queuePosition = getQueuePosition(queue, shop);

        // Save Queue Order
        QueueOrder queueOrder = new QueueOrder();
        queueOrder.setId(QueueOrderEmbeddedKey.builder()
                .orderId(order.getId())
                .queueId(queue.getId())
                .build());
        queueOrder.setCreatedOn(LocalDateTime.now());
        queueOrder.setExpectedWaitTime(expectedWaitingTime);
        queueOrder.setQueue(queue);
        queueOrder.setPosition(queuePosition);
        return queueOrderRepository.save(queueOrder);
    }

    private Integer getQueuePosition(Queue queue, Shop shop) {
        int currentQueueSize = queue.getQueueOrders().size();
        if (currentQueueSize >= shop.getQueueSize()) {
            throw new ConflictingDataException("Queue is fulled, can not add a new order");
        }

        return queue.getQueueOrders().size() + 1;
    }

    private LocalDateTime getExpectedWaitingTime(UUID shopId) {
        return LocalDateTime.now();
    }
}
