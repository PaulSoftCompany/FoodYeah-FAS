package com.paulsoft.food.dtos.orderDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    private Long id;
    private Byte quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String unitName;
}
