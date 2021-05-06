package com.paulsoft.foodyeah.foodcontext.repository;

import com.paulsoft.foodyeah.foodcontext.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
