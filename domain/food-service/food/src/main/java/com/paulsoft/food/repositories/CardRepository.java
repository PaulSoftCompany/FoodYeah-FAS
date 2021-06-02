package com.paulsoft.food.repositories;

import com.paulsoft.food.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findAllByCustomerId(Long id);
    Optional<Card> findCardByCardNumber(Long number);
}
