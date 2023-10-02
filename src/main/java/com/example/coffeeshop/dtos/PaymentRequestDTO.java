package com.example.coffeeshop.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequestDTO {
    private BigDecimal amount;
    private UUID paymentMethodId;
}
