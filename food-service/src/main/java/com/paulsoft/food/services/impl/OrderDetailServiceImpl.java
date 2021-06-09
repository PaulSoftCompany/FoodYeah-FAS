package com.paulsoft.food.services.impl;

import com.paulsoft.food.dtos.orderDetailDto.CreateOrderDetailDto;
import com.paulsoft.food.dtos.orderDetailDto.OrderDetailDto;
import com.paulsoft.food.dtos.orderDetailDto.UpdateOrderDetailDto;
import com.paulsoft.food.dtos.orderDto.CreateOrderDto;
import com.paulsoft.food.dtos.orderDto.OrderDto;
import com.paulsoft.food.entities.Order;
import com.paulsoft.food.entities.OrderDetail;
import com.paulsoft.food.exceptions.NotFoundException;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.repositories.CardRepository;
import com.paulsoft.food.repositories.OrderDetailRepository;
import com.paulsoft.food.repositories.OrderRepository;
import com.paulsoft.food.services.OrderDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailServiceImpl  implements OrderDetailService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CardRepository cardRepository;

    public static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public OrderDetailDto getOrderDetailById(Long id) throws ResourceException {
        return convertToResource(orderDetailRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND")));
    }

    @Override
    public List<OrderDetailDto> getOrderDetails() throws ResourceException {
        return orderDetailRepository.findAll()
                .stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderDetailDto updateOrderDetailDto(UpdateOrderDetailDto updateOrderDetailDto, Long id) throws ResourceException {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
        orderDetail.setQuantity(updateOrderDetailDto.getQuantity());
        orderDetail.setTotalPrice(orderDetail.getQuantity() * orderDetail.getUnitPrice());
        return convertToResource(orderDetailRepository.save(orderDetail));
    }

    private OrderDetail convertToEntity(CreateOrderDetailDto resource){
        return modelMapper.map(resource, OrderDetail.class);
    }

    private OrderDetailDto convertToResource(OrderDetail entity){
        return modelMapper.map(entity,OrderDetailDto.class);
    }
}
