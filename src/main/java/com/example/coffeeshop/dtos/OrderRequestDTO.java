package com.example.coffeeshop.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
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
    @Min(0)
    private BigDecimal totalPrice;

    @NotNull
    @Min(0)
    private Integer totalAmount;

    @NotNull
    private UUID shopId;

    @Valid
    private List<OrderItemRequestDTO> orderItems;
}
