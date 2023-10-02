package com.example.coffeeshop.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderRequestDTO {
    @NotNull
    private UUID customerId;

    @NotNull
    private UUID paymentId;

    @NotNull
    private UUID shopId;

    @Valid
    private List<OrderItemRequestDTO> orderItems;
}
