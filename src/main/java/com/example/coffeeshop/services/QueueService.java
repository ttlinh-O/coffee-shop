package com.example.coffeeshop.services;

import com.example.coffeeshop.entities.Queue;
import com.example.coffeeshop.entities.Shop;
import com.example.coffeeshop.exceptions.ResourceNotFoundException;
import com.example.coffeeshop.repositories.QueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final QueueRepository queueRepository;

    /***
     * Find next queue for order of customer base on given shop
     *
     * @param shop is shop of queues
     * @return the queue which have min size
     */
    @Transactional
    public Queue findNextQueue(Shop shop) {
        List<Queue> queues = queueRepository.findQueueByShopId(shop);
        return queues.stream().min(Comparator.comparingInt(queue -> queue.getQueueOrders().size()))
                .orElseThrow(() -> new ResourceNotFoundException("Queue not found"));
    }
}
