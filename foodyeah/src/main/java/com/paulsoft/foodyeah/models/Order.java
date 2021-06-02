package com.paulsoft.foodyeah.models;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;

    private Date date;

    private Double totalPrice;

    private List<OrderDetail> details;

    private Customer customer;

}