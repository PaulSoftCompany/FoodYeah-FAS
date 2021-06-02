package com.paulsoft.inventory.entities;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Long id;

    private String name;

    private Double productPrice;

    private Byte sellDay;

    private String imageUrl;

    private Boolean state;

    private Date createdAt;

    private ProductCategory productCategory;

    private List<OrderDetail> orders;

}