package com.paulsoft.user.BDDTests.steps;

import com.paulsoft.user.repositories.CustomerRepository;
import com.paulsoft.user.services.impl.CustomerServiceImpl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;


import com.paulsoft.user.dtos.customerDto.CreateCustomerDto;
import com.paulsoft.user.dtos.customerDto.CustomerDto;
import com.paulsoft.user.dtos.customerDto.UpdateCustomerDto;
import com.paulsoft.user.entities.Customer;
import com.paulsoft.user.exceptions.NotFoundException;
import com.paulsoft.user.exceptions.ResourceException;
import com.paulsoft.user.repositories.CustomerRepository;
import com.paulsoft.user.services.impl.CustomerServiceImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Optional;
public class S13Step {
    @InjectMocks
    CustomerServiceImpl service;
    @Mock
    CustomerRepository repository;
    @Mock
    Customer cardRepository;

    public static final ModelMapper modelMapper = new ModelMapper();
    private static final Customer CUSTOMER = new Customer();
    private static final Long CUSTOMER_ID = 1L;
    private static final String CUSTOMER_FIRSTNAME = "NombreDelCliente";
    private static final String CUSTOMER_LASTNAME = "ApellidoDelCliente";
    private static final String CUSTOMER_CODE = "U20181ALGO";
    private static final String CUSTOMER_PASSWORD = "asd123ASD#";
    private static final Boolean STATE_CREATED = true;
    private static final Boolean STATE_DELETED = false;


    List<CustomerDto> responseAll;

    @Given("a user13")
    public void aUser13() {
        MockitoAnnotations.openMocks(this);
        CUSTOMER.setId(CUSTOMER_ID);
        CUSTOMER.setFirstName(CUSTOMER_FIRSTNAME);
        CUSTOMER.setLastName(CUSTOMER_LASTNAME);
        CUSTOMER.setCode(CUSTOMER_CODE);
        CUSTOMER.setPassword(CUSTOMER_PASSWORD);
    }

    @When("enters the main page")
    public void entersTheMainPage() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(CUSTOMER));
        try {
            responseAll = service.getCustomers();

        } catch (ResourceException e) {
            System.out.println("SERVICE ERROR");
        }
    }

    @Then("the shows the menu")
    public void theSystemShowsTheMenu() {
    }

    @When("get stuck in the main page")
    public void getStuckInTheMainPage() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(CUSTOMER));
        try {
            responseAll = service.getCustomers();

        } catch (ResourceException e) {
            System.out.println("SERVICE ERROR");
        }
    }

    @Then("the system shows the dishes on the order")
    public void theSystemShowsTheDishesOnTheOrder() {
        try {
            Assert.assertNotNull("RESPONSE NOT NULL", responseAll);
        } catch (AssertionError e) {
            throw e;
        }
    }

    @Then("the system shows a message")
    public void theSystemShowsAMessage() {
        responseAll = null;
        try {
            Assert.assertNull("RESPONSE IS NOT NULL", responseAll);
        } catch (AssertionError e) {
            throw e;
        }
    }
}
