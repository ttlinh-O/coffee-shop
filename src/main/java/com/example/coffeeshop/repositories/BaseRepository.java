package com.example.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

/**
 * Extends JpaRepository with an interface for dynamic projections.
 *
 * Read more {@see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projection.dynamic }
 *
 * @param <T> Entity type to fetch.
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, UUID> {

    // find all and map to the desired projection
    <Dto> List<Dto> findBy(Class<Dto> type);
    <Dto> Dto findById(UUID id, Class<Dto> type);
}
