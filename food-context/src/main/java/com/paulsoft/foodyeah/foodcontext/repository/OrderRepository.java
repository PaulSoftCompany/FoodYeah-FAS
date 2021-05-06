package com.paulsoft.foodyeah.foodcontext.repository;

import com.paulsoft.foodyeah.foodcontext.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
