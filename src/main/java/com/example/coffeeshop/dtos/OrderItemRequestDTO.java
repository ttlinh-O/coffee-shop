package com.example.coffeeshop.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequestDTO {
    @NotNull
    private UUID itemId;

    @NotNull
    @Positive
    private Integer amount;

    @NotNull
    @Min(0)
    private BigDecimal price;
}
