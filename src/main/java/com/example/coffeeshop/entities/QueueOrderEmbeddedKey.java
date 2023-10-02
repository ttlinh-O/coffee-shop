package com.example.coffeeshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueOrderEmbeddedKey implements Serializable {

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "queue_id")
    private UUID queueId;
}
