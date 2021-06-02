package com.paulsoft.user.controller;
import com.paulsoft.user.dtos.customerDto.CreateCustomerDto;
import com.paulsoft.user.dtos.customerDto.CustomerDto;
import com.paulsoft.user.dtos.customerDto.UpdateCustomerDto;
import com.paulsoft.user.exceptions.ResourceException;
import com.paulsoft.user.responses.ResourceResponse;
import com.paulsoft.user.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<CustomerDto>> getCustomers() throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.getCustomers());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("?state={state}")
    public ResourceResponse<List<CustomerDto>> getCustomersByState(@PathVariable("state") Boolean state) throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.getCustomersByState(state));
    }
    //TODO: Corregir el de state (no sale correcto)

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResourceResponse<CustomerDto> createCustomer(@RequestBody @Valid CreateCustomerDto createCustomerDto ) throws ResourceException, ParseException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.createCustomer(createCustomerDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<CustomerDto> getCustomerById(@PathVariable("id") Long id) throws ResourceException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.getCustomerById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("?code={code}")
    public ResourceResponse<CustomerDto> getCustomerByCode(@PathVariable("code") String code) throws ResourceException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.getCustomerByCode(code));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResourceResponse<String> deleteCustomer(@PathVariable("id") Long id)throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                customerService.deleteCustomer(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResourceResponse<CustomerDto> updateCustomer(@RequestBody @Valid UpdateCustomerDto updateCustomerDto, @PathVariable("id") Long id) throws ResourceException{
        return new ResourceResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                customerService.updateCustomer(updateCustomerDto,id));
    }
}
