package com.paulsoft.food.controllers;

import com.paulsoft.food.dtos.orderDto.CreateOrderDto;
import com.paulsoft.food.dtos.orderDto.OrderDto;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.responses.ResourceResponse;
import com.paulsoft.food.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<OrderDto>> getOrders() throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                orderService.getOrders());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResourceResponse<OrderDto> createOrder(@RequestBody @Valid CreateOrderDto createOrderDto ) throws ResourceException, ParseException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                orderService.createOrder(createOrderDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{orderId}/payment/{cardId}")
    public ResourceResponse<String> payment(@PathVariable("orderId") Long orderId, @PathVariable("cardId") Long cardId) throws ResourceException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                String.format("Order %d paid",orderId));

    }


}