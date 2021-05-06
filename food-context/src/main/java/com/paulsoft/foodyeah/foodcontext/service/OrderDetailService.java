package com.paulsoft.foodyeah.foodcontext.service;

import com.paulsoft.foodyeah.foodcontext.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> findOrderDetailAll();
    OrderDetail getOrderDetail(Long id);

    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    OrderDetail deleteOrderDetail(Long id);
}
