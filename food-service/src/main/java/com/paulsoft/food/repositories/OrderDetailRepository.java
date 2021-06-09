package com.paulsoft.food.repositories;

import com.paulsoft.food.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    Optional<List<OrderDetail>> findAllByOrderId(Long aLong);
}