package com.example.coffeeshop.services;

import com.example.coffeeshop.dtos.OrderItemRequestDTO;
import com.example.coffeeshop.dtos.OrderRequestDTO;
import com.example.coffeeshop.dtos.OrderResponseDTO;
import com.example.coffeeshop.entities.*;
import com.example.coffeeshop.enums.OrderStatus;
import com.example.coffeeshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShopService shopService;
    private final QueueOrderService queueOrderService;
    private final MenuItemService menuItemService;
    private final CustomerService customerService;
    private final PaymentService paymentService;

    /***
     * Create an order
     * @param orderRequestDTO information of an order
     * @return order response
     */
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        menuItemService.validateOrderItems(orderRequestDTO.getOrderItems());

        //Save order
        Integer totalAmount = getTotalAmount(orderRequestDTO);
        BigDecimal totalPrice = getTotalPrice(orderRequestDTO);
        Shop shop = shopService.getShopById(orderRequestDTO.getShopId());
        Customer customer = customerService.findCustomerById(orderRequestDTO.getCustomerId());
        Payment payment = paymentService.findPaymentById(orderRequestDTO.getPaymentId());
        Order order = Order.builder()
                .orderStatus(OrderStatus.ORDERED)
                .customer(customer)
                .payment(payment)
                .date(LocalDateTime.now())
                .totalPrice(totalPrice)
                .totalAmount(totalAmount)
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

    private static BigDecimal getTotalPrice(OrderRequestDTO orderRequestDTO) {
        return orderRequestDTO.getOrderItems().stream()
                .map(item -> BigDecimal.valueOf(item.getAmount()).multiply(item.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static Integer getTotalAmount(OrderRequestDTO orderRequestDTO) {
        return orderRequestDTO.getOrderItems().stream().map(OrderItemRequestDTO::getAmount)
                .reduce(0, Integer::sum, Integer::sum);
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
