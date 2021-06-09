package com.paulsoft.food.dtos.orderDto;

import java.util.Date;
import java.util.List;

import com.paulsoft.food.dtos.orderDetailDto.OrderDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private Date date;
    private Double totalPrice;
    private List<OrderDetailDto> details;
    private Long customerId;
}
