package com.paulsoft.inventory.entities;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategory {
    private Long id;

    private String name;

    private String description;

    private Date createdAt;

    private Boolean state;

    private List<Product> products;
}