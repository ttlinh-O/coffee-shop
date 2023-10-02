package com.example.coffeeshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "queue_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueueOrder {

    @EmbeddedId
    private QueueOrderEmbeddedKey id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Queue queue;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "expected_wait_time", nullable = false)
    private LocalDateTime expectedWaitTime;

    @Column(name = "position", nullable = false)
    private Integer position;
}
