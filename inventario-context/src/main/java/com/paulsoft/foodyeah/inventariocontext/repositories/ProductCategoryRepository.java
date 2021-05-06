package com.paulsoft.foodyeah.inventariocontext.repositories;

import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findByName(String name) throws ResourceException;
}
