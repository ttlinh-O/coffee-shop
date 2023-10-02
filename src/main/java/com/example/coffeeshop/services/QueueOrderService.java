package com.example.coffeeshop.services;

import com.example.coffeeshop.entities.*;
import com.example.coffeeshop.exceptions.ConflictingDataException;
import com.example.coffeeshop.repositories.MenuRepository;
import com.example.coffeeshop.repositories.QueueOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class QueueOrderService {
    private final QueueOrderRepository queueOrderRepository;
    private final QueueService queueService;
    private final MenuRepository menuRepository;

    /**
     * creates a new queue order
     * @param shop refer {@link Shop}
     * @param order refer {@link Order}
     * @return {@link QueueOrder} after created
     */
    @Transactional
    public QueueOrder saveQueueOrder(Shop shop, Order order) {
        Queue queue = queueService.findNextQueue(shop);
        LocalDateTime expectedWaitingTime = getExpectedWaitingTime(shop, queue);
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

    // If still have time, will calculate based on menu.time_prepare
    private LocalDateTime getExpectedWaitingTime(Shop shop, Queue queue) {
//        List<Menu> menus = menuRepository.findAllByShop(shop);
//        Map<UUID, MenuItem> menuItemMap = menus.stream().map(menu -> menu.getMenuItems())
//                .flatMap(Collection::stream)
//                .collect(Collectors.toMap(MenuItem::getId, Function.identity()));

        return LocalDateTime.now().plusMinutes(30);
    }
}
