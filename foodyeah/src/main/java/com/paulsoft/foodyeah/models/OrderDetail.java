package com.paulsoft.foodyeah.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetail {
    private Long id;

    private Byte quantity;

    private Double unitPrice;

    private String unitName;

    private Double totalPrice;

    private Order order;

    private Product product;
}
