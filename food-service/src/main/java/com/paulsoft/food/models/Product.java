package com.paulsoft.food.models;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Double productPrice;
    private Byte sellDay;
    private String imageUrl;
    private Boolean state;
    private Date createdAt;
    private Long productCategoryId;
}
