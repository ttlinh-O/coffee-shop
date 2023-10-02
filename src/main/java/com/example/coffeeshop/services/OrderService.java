package com.example.coffeeshop.services;

import com.example.coffeeshop.dtos.OrderRequestDTO;
import com.example.coffeeshop.dtos.OrderResponseDTO;
import com.example.coffeeshop.entities.*;
import com.example.coffeeshop.enums.OrderStatus;
import com.example.coffeeshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShopService shopService;
    private final QueueOrderService queueOrderService;

    /***
     * Create an order
     * @param orderRequestDTO information of an order
     * @return order response
     */
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        // check if payment equal with total amount?

        //Save Order
        Shop shop = shopService.getShopById(orderRequestDTO.getShopId());
        Order order = Order.builder()
                .orderStatus(OrderStatus.ORDERED)
                .customer(Customer.builder().id(orderRequestDTO.getCustomerId()).build())
                .payment(Payment.builder().id(orderRequestDTO.getPaymentId()).build())
                .date(LocalDateTime.now())
                .totalPrice(orderRequestDTO.getTotalPrice())
                .totalAmount(orderRequestDTO.getTotalAmount())
                .shop(shop)
                .build();

        List<OrderDetail> orderDetails = orderRequestDTO.getOrderItems()
                .stream()
                .map(item -> OrderDetail.builder()
                        .menuItem(MenuItem.builder().id(item.getItemId()).build())
                        .amount(item.getAmount())
                        .price(item.getPrice())
                        .order(order)
                        .build())
                .toList();
        order.setOrderDetails(orderDetails);
        Order orderSaved = orderRepository.save(order);

        // Save queue order
        QueueOrder queueOrderSaved = queueOrderService.saveQueueOrder(shop, orderSaved);

        return buildResponse(orderSaved, queueOrderSaved);
    }

    private static OrderResponseDTO buildResponse(Order orderSaved, QueueOrder queueOrderSaved) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(orderSaved.getId());
        orderResponseDTO.setQueuePosition(queueOrderSaved.getPosition());
        orderResponseDTO.setExpectedWaitingTime(queueOrderSaved.getExpectedWaitTime());
        orderResponseDTO.setStatus(OrderStatus.ORDERED);
        return orderResponseDTO;
    }
}
