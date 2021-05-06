package com.paulsoft.foodyeah.foodcontext.service.impl;

import com.paulsoft.foodyeah.foodcontext.entity.Card;
import com.paulsoft.foodyeah.foodcontext.entity.Order;
import com.paulsoft.foodyeah.foodcontext.entity.OrderDetail;
import com.paulsoft.foodyeah.foodcontext.model.Product;
import com.paulsoft.foodyeah.foodcontext.repository.CardRepository;
import com.paulsoft.foodyeah.foodcontext.repository.OrderDetailRepository;
import com.paulsoft.foodyeah.foodcontext.repository.OrderRepository;
import com.paulsoft.foodyeah.foodcontext.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private CardRepository cardRepository;



    @Override
    public List<Order> findOrderAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        //PrepareDetail(order);
        PrepareHeader(order);
        return orderRepository.save(order);
    }

    private void PrepareHeader(Order order) {
        order.setState("CREATED");
        order.setDate( new Date());
        order.setTotalPrice((double) OrderTotalPrice(order));
        order.setInittime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        order.setEndtime("00:00:00");
    }

    /*private void PrepareDetail(Order order) {
        List<OrderDetail> _orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : _orderDetails) {
            Product product = productRepository.getOne(orderDetail.getProduct().getId());
            orderDetail.setUnitPrice(product.getProductPrice());
            orderDetail.setTotalPrice(orderDetail.getUnitPrice() * orderDetail.getQuantity());
            orderDetail.setState("CREATED");
            orderDetailRepository.save(orderDetail);
        }
    }*/

    public void SetEndTime(Order order) {
        order.setEndtime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        order.setState("DELIVERED");
        orderRepository.save(order);
    }



    public String GetAverageTime() {
        String s = "00:00:00";
        Long averageTime = 0L;
        int quant = 0;
        for (Order order : orderRepository.findAll()) {
            if (order.getEndtime() == "00:00:00")
                continue;
            quant++;

            LocalDateTime _inittime = LocalDateTime.parse("2018-11-03T" + order.getInittime());
            LocalDateTime _endtime = LocalDateTime.parse("2018-11-03T" + order.getEndtime());

            averageTime += _inittime.until(_endtime, ChronoUnit.MINUTES);
        }

        if (quant == 0)
            return "5";

        averageTime /= quant;

        if (averageTime == 0)
            return "1";

        return averageTime.toString();
    }

    private float OrderTotalPrice(Order order) {
        float TotalPrice = 0;
        List<OrderDetail> _orderDetails = order.getOrderDetails();
        for (OrderDetail orderDetail : _orderDetails) {
            TotalPrice += orderDetail.getTotalPrice();
        }
        return TotalPrice;
    }

    public boolean DecreaseCostumerMoney(long cardId, long orderId)
    {
        Order order = getOrder(orderId);
        Card card = cardRepository.getOne(cardId);

        if ((card.getCardMoney() - order.getTotalPrice()) >= 0)
        {
            card.setCardMoney((float) (card.getCardMoney() - order.getTotalPrice()));
            cardRepository.save(card);
            return true;
        }
        return false;
    }
}
