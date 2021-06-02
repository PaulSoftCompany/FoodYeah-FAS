package com.paulsoft.food.dtos.orderDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDetailDto {
    private Byte quantity;
    private Long productId;
}
