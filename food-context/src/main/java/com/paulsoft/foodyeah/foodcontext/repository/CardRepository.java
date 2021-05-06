package com.paulsoft.foodyeah.foodcontext.repository;

import com.paulsoft.foodyeah.foodcontext.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
