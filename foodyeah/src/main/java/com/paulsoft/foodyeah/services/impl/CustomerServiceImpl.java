package com.paulsoft.foodyeah.services.impl;

import com.paulsoft.foodyeah.exceptions.NotFoundException;
import com.paulsoft.foodyeah.exceptions.ResourceException;
import com.paulsoft.foodyeah.dtos.CreateCustomerDto;
import com.paulsoft.foodyeah.dtos.CustomerDto;
import com.paulsoft.foodyeah.entities.Customer;
import com.paulsoft.foodyeah.repositories.CustomerRepository;
import com.paulsoft.foodyeah.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public CustomerDto getCustomerByCode(String code) throws ResourceException {
        return convertToResource(customerRepository.findByCode(code)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND")));
    }

    @Override
    public CustomerDto getCustomerById(Long id) throws ResourceException {
        return convertToResource(customerRepository.findById(id)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND")));
    }

    @Override
    public List<CustomerDto> getCustomersByState(Boolean state) throws ResourceException {
        return customerRepository.findAllByState(state)
                .stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomers() throws ResourceException {
        return customerRepository.findAll()
                .stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) throws ResourceException {
        Customer customer = convertToEntity(createCustomerDto);
        if(customerRepository.findByCode(createCustomerDto.getCode()).isPresent()){
            throw new NotFoundException("CUSTOMER_EXISTS","CUSTOMER_EXISTS");
        }
        customer.setState(true);
        return convertToResource(customerRepository.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(CreateCustomerDto updateCustomerDto, Long id) throws ResourceException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND"));
        customer.setFirstName(updateCustomerDto.getFirstName());
        customer.setLastName(updateCustomerDto.getLastName());
        return convertToResource(customerRepository.save(customer));
    }

    @Override
    public String deleteCustomer(Long id) throws ResourceException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND"));
        customer.setState(false);
        return customer.getCode();
    }

    private Customer convertToEntity(CreateCustomerDto resource){return  modelMapper.map(resource, Customer.class);}

    private CustomerDto convertToResource(Customer entity){return  modelMapper.map(entity,CustomerDto.class);}
}
