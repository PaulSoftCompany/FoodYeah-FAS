package com.paulsoft.food.clients;

import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.models.Customer;
import com.paulsoft.food.responses.ResourceResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "customer-service")
@RequestMapping(value = "/customers")
public interface CustomerClient {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<Customer> getCustomerById(@PathVariable("id") Long id) throws ResourceException;
}