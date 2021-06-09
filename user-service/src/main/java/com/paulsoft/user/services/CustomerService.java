package com.paulsoft.user.services;

import com.paulsoft.user.dtos.customerDto.CreateCustomerDto;
import com.paulsoft.user.dtos.customerDto.CustomerDto;
import com.paulsoft.user.dtos.customerDto.UpdateCustomerDto;
import com.paulsoft.user.exceptions.ResourceException;

import java.util.List;
import java.text.ParseException;

public interface CustomerService {
    CustomerDto getCustomerByCode(String code) throws ResourceException;

    CustomerDto getCustomerById(Long id) throws ResourceException;

    List<CustomerDto> getCustomersByState(Boolean state) throws ResourceException;

    List<CustomerDto> getCustomers() throws ResourceException;

    CustomerDto createCustomer(CreateCustomerDto createCustomerDto) throws ResourceException, ParseException;

    CustomerDto updateCustomer(UpdateCustomerDto updateCustomerDto, Long id) throws ResourceException;

    String deleteCustomer(Long id) throws ResourceException;
}
