package com.paulsoft.user.models;

import lombok.Getter;

@Getter
public class OrderDetail {
    private Long id;
    private Byte quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String unitName;
}
