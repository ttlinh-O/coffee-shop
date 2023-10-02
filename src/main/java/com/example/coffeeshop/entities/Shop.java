package com.example.coffeeshop.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Shop {
    @Id
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "time_open", nullable = false, columnDefinition = "integer default 0")
    private Integer timeOpen = 0;

    @Column(name = "time_close", nullable = false, columnDefinition = "integer default 0")
    private Integer timeClose = 0;

    @Column(name = "queue_size", nullable = false, columnDefinition = "integer default 1")
    private Integer queueSize = 1;

    @Column(name = "queue_amount", nullable = false, columnDefinition = "integer default 0")
    private Integer queueAmount = 0;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Score> scores;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Queue> queues;

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
