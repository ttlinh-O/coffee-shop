package com.example.coffeeshop.repositories;

import com.example.coffeeshop.entities.Menu;
import com.example.coffeeshop.entities.Shop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends  BaseRepository<Menu>{

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {
            "menuItems"
    })
    List<Menu> findAllByShop(Shop shop);
}
