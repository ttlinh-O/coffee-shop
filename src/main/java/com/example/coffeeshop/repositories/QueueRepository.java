package com.example.coffeeshop.repositories;

import com.example.coffeeshop.entities.Queue;
import com.example.coffeeshop.entities.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QueueRepository extends BaseRepository<Queue> {

    @Query("""
            select q
            from Queue q left join fetch q.queueOrders
            where q.shop = ?1
        """)
    List<Queue> findQueueByShopId(Shop shop);
}
