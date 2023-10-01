package com.example.coffeeshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "queue_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueueOrder {
    @Id
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", unique = true)
    private Order order;

    // Define a Many-to-One relationship to the Queue entity
    @ManyToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "id")
    private Queue queue;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "expected_wait_time", nullable = false)
    private LocalDateTime expectedWaitTime;
}
