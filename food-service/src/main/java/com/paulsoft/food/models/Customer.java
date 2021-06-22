package com.paulsoft.food.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paulsoft.food.dtos.orderDto.OrderDto;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String code;
    private Boolean state;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    private List<OrderDto> orders;
}