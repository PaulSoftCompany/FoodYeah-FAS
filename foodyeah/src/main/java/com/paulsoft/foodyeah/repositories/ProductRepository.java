package com.paulsoft.foodyeah.repositories;

import com.paulsoft.foodyeah.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //TODO
}
