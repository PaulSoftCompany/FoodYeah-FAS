package com.paulsoft.user.models;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Order {
    private Long id;
    private Date date;
    private Double totalPrice;
    private List<OrderDetail> details;
    private Long customerId;
}
