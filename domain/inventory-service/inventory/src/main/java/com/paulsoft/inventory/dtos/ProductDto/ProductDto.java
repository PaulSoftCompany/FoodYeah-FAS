package com.paulsoft.inventory.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private Double productPrice;
    private Byte sellDay;
    private String imageUrl;
    private Boolean state;
    private Date createdAt;
    private Long productCategoryId;

}
