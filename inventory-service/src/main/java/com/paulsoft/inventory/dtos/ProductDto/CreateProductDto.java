package com.paulsoft.inventory.dtos.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String name;
    private Double productPrice;
    private byte sellDay;
    private String imageUrl;
    private Long productCategoryId;
}
