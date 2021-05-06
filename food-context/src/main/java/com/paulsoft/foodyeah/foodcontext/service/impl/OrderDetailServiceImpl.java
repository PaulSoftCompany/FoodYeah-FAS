package com.paulsoft.foodyeah.foodcontext.service.impl;

import com.paulsoft.foodyeah.foodcontext.entity.OrderDetail;
import com.paulsoft.foodyeah.foodcontext.repository.OrderDetailRepository;
import com.paulsoft.foodyeah.foodcontext.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {


    @Autowired
    public static OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetail> findOrderDetailAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetail(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {

        orderDetail.setState("CREATED");
        return orderDetailRepository.save(orderDetail);

    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        OrderDetail orderDetailDB = this.getOrderDetail(orderDetail.getId());
        if (orderDetailDB == null) {
            return null;
        }
        orderDetailDB.setOrder(orderDetail.getOrder());
        orderDetailDB.setProduct(orderDetail.getProduct());
        orderDetailDB.setQuantity(orderDetail.getQuantity());
        orderDetailDB.setState("UPDATED");
        orderDetailDB = orderDetailRepository.save(orderDetail);
        return orderDetailDB;
    }

    @Override
    public OrderDetail deleteOrderDetail(Long id) {
        OrderDetail orderDetailDB = this.getOrderDetail(id);
        if (orderDetailDB == null) {
            return null;
        }
        orderDetailDB.setState("DELETED");
        return orderDetailRepository.save(orderDetailDB);
    }
}
