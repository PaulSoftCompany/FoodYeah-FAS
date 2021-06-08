package com.paulsoft.food.repositories;

import com.paulsoft.food.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    // List<Order> findAllByCustomerId(Long id);
}
