package com.paulsoft.inventory.models.OrderDetail;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDetail {
    private Long id;
    private Byte quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String unitName;
}
