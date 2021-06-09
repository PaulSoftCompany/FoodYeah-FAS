package com.paulsoft.user.repositories;

import com.paulsoft.user.entities.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByCode(String code);
    List<Customer> findAllByState(Boolean State);
}
