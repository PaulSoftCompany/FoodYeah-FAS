package com.paulsoft.food.dtos.orderDto;
import java.util.List;

import com.paulsoft.food.dtos.orderDetailDto.CreateOrderDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDto {
    private List<CreateOrderDetailDto> details;
    private Long customerId;
}
