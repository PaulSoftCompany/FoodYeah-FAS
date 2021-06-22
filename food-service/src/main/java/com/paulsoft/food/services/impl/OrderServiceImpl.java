package com.paulsoft.food.services.impl;

import com.paulsoft.food.clients.UserClient;
import com.paulsoft.food.clients.ProductClient;
import com.paulsoft.food.dtos.orderDetailDto.CreateOrderDetailDto;
import com.paulsoft.food.dtos.orderDto.CreateOrderDto;
import com.paulsoft.food.dtos.orderDto.OrderDto;
import com.paulsoft.food.entities.Order;
import com.paulsoft.food.entities.OrderDetail;
import com.paulsoft.food.exceptions.NotFoundException;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.models.Customer;
import com.paulsoft.food.models.Product;
import com.paulsoft.food.repositories.OrderDetailRepository;
import com.paulsoft.food.repositories.OrderRepository;
import com.paulsoft.food.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    UserClient customerClient;

    @Autowired
    ProductClient productClient;

    public static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public List<OrderDto> getOrders() throws ResourceException {
        return convertToResources(orderRepository.findAll());
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(Long id) throws ResourceException {
        // return convertToResources(orderRepository.findAllByCustomerId(id));
        return null;
    }

    @Override
    public OrderDto getOrderById(Long id) throws ResourceException {
        return convertToResource(getOrderEntity(id));
    }

    @Override
    @Transactional
    public OrderDto createOrder(CreateOrderDto createOrderDto) throws ResourceException, ParseException {
        Customer customer = customerClient.getCustomerById(createOrderDto.getCustomerId()).getData();
        Order order = new Order();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(formatter.format(new Date()));
        order.setDate(date);
        order.setTotalPrice(0d);
        order.setCustomer(customer);
        orderRepository.save(order);
        Double total = 0d;
        List<CreateOrderDetailDto> orderDetails = createOrderDto.getDetails();
        for (CreateOrderDetailDto orderDetail : orderDetails) {
            OrderDetail orderDetailEntity = new OrderDetail();
            Product product = productClient.getProductById(orderDetail.getProductId()).getData();

            orderDetailEntity.setOrder(order);
            orderDetailEntity.setProduct(product);
            orderDetailEntity.setUnitName(product.getName());
            orderDetailEntity.setUnitPrice(product.getProductPrice());
            orderDetailEntity.setQuantity(orderDetail.getQuantity());
            orderDetailEntity.setTotalPrice(product.getProductPrice() * orderDetail.getQuantity());
            total += orderDetailEntity.getTotalPrice();
            orderDetailRepository.save(orderDetailEntity);
        }
        order.setTotalPrice(total);
        return convertToResource(orderRepository.save(order));
    }

    private Order getOrderEntity(Long id) throws ResourceException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    private List<OrderDto> convertToResources(List<Order> orders) {
        return orders.stream().map(x -> modelMapper.map(x, OrderDto.class)).collect(Collectors.toList());
    }

    private Order convertToEntity(CreateOrderDto resource) {
        return modelMapper.map(resource, Order.class);
    }

    private OrderDto convertToResource(Order entity) {
        return modelMapper.map(entity, OrderDto.class);
    }
}
