package com.paulsoft.inventory.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private Long id;
    private Byte quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String unitName;
}
