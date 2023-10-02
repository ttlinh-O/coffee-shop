package com.example.coffeeshop.entities;

import com.example.coffeeshop.enums.QueueStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "queue")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Queue {
    @Id
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "queue_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QueueStatus queueStatus;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    @OneToMany(mappedBy = "queue", fetch = FetchType.LAZY)
    private List<QueueOrder> queueOrders;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_id")
    private UUID createdId;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "updated_id")
    private UUID updatedId;

    @Column(name = "deleted_on")
    private LocalDateTime deletedOn;

    @Column(name = "deleted_id")
    private UUID deletedId;
}
