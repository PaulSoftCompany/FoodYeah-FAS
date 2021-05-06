package com.example.foodcontext.repository;

import com.example.foodcontext.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
