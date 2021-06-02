package com.paulsoft.inventory.models.Order;

import com.paulsoft.inventory.models.OrderDetail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.SecondaryTable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
    private Long id;
    private Date date;
    private Double totalPrice;
    private List<OrderDetailDto> details;
    private Long customerId;
}
