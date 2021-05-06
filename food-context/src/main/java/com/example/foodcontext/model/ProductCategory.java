package com.example.foodcontext.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategory {

    private Long id;

    private String name;

    private String description;

    private List<Product> products;
}
