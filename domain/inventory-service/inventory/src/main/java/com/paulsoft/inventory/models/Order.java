package com.paulsoft.inventory.models;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private Date date;
    private Double totalPrice;
    private List<OrderDetail> details;
    private Long customerId;
}
