package com.example.foodcontext.repository;

import com.example.foodcontext.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
