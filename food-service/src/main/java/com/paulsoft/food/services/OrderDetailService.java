package com.paulsoft.food.services;

import com.paulsoft.food.dtos.orderDetailDto.OrderDetailDto;
import com.paulsoft.food.dtos.orderDetailDto.UpdateOrderDetailDto;
import com.paulsoft.food.exceptions.ResourceException;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto getOrderDetailById(Long id) throws ResourceException;
    List<OrderDetailDto> getOrderDetails() throws ResourceException;
    OrderDetailDto updateOrderDetailDto(UpdateOrderDetailDto updateOrderDetailDto, Long id) throws ResourceException;
}
