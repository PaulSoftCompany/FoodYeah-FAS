package com.paulsoft.food.services;

import com.paulsoft.food.dtos.orderDto.CreateOrderDto;
import com.paulsoft.food.dtos.orderDto.OrderDto;
import com.paulsoft.food.exceptions.ResourceException;

import java.text.ParseException;
import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders() throws ResourceException;
    List<OrderDto> getOrdersByCustomerId(Long id) throws ResourceException;
    OrderDto getOrderById(Long id) throws ResourceException;
    OrderDto createOrder(CreateOrderDto createOrderDto) throws ResourceException, ParseException;
}
