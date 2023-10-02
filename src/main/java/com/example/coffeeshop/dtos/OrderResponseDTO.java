package com.example.coffeeshop.dtos;

import com.example.coffeeshop.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private UUID id;
    private Integer queuePosition;
    private LocalDateTime expectedWaitingTime;
    private OrderStatus status;
}
