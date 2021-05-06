package com.paulsoft.foodyeah.inventariocontext.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private byte sellday;
    private String imageUrl;
    private String[] ingredients;
    private int stock;
    private String state;
    private ProductCategoryDto productCategory;
}
