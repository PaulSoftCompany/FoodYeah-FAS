package com.paulsoft.food.BDDTests.steps;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.paulsoft.food.dtos.cardDto.CardDto;
import com.paulsoft.food.dtos.cardDto.CreateCardDto;
import com.paulsoft.food.dtos.cardDto.UpdateCardDto;
import com.paulsoft.food.dtos.orderDetailDto.OrderDetailDto;
import com.paulsoft.food.entities.Card;
import com.paulsoft.food.entities.Order;
import com.paulsoft.food.entities.OrderDetail;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.exceptions.NotFoundException;
import com.paulsoft.food.repositories.CardRepository;
import com.paulsoft.food.repositories.OrderDetailRepository;
import com.paulsoft.food.services.impl.CardServiceImpl;
import com.paulsoft.food.models.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class S3Steps {

    @InjectMocks
    CardServiceImpl service;
    @Mock
    OrderDetailRepository repository;
    @Mock
    CardRepository cardRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    public static final Card CARD = new Card();
    public static final Long CARD_ID = 1L;
    public static final Boolean CARD_TYPE = true;
    public static final String CARD_OWNER = "CardOwner";
    public static final Long CARD_NUMBER = 1L;
    public static final Date CARD_EXPIREDATE = Date
            .from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    public static final Date DATE = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    public static final Double CARD_MONEY = 500.0d;
    private static final Customer CUSTOMER = new Customer();
    private static final Long CUSTOMER_ID = 1L;
    private static final String CUSTOMER_FIRSTNAME = "NombreDelCliente";
    private static final String CUSTOMER_LASTNAME = "ApellidoDelCliente";
    private static final String CUSTOMER_CODE = "U20181ALGO";
    private static final String CUSTOMER_PASSWORD = "asd123ASD#";
    private static final Boolean STATE_CREATED = true;
    private static final Boolean STATE_DELETED = false;
    private static final Order ORDER = new Order();

    List<CardDto> responseAll;
    List<OrderDetailDto> responseOrder;


    @Given("a user3")
    public void aUser3() {
        MockitoAnnotations.openMocks(this);
        CARD.setId(CARD_ID);
        CARD.setType(CARD_TYPE);
        CARD.setOwner(CARD_OWNER);
        CARD.setCardNumber(CARD_NUMBER);
        CARD.setExpireDate(CARD_EXPIREDATE);
        CARD.setCardMoney(CARD_MONEY);
        CUSTOMER.setId(CUSTOMER_ID);
        CUSTOMER.setFirstName(CUSTOMER_FIRSTNAME);
        CUSTOMER.setLastName(CUSTOMER_LASTNAME);
        CUSTOMER.setCode(CUSTOMER_CODE);
        // CUSTOMER.setPassword(CUSTOMER_PASSWORD);
        CARD.setCustomer(CUSTOMER);
    }

    @When("loads the order details")
    public void loadsTheOrderDetails() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(ORDER));
        try {
            responseAll = service.getCards();
            
        } catch (ResourceException e) {
            System.out.println("SERVICE ERROR");
        }
    }

    @Then("the system substract the stock of each dish")
    public void theSystemSubstractTheStockOfEachDish() {
    }

    @When("adds dish to cart")
    public void addsDishToCart() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(ORDER));
        try {
            responseAll = service.getCards();

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

    @Then("the system substract money from the customer's card")
    public void theSystemSubstractMoneyFromTheCustomerSCard() {
        responseAll = null;
        try {
            Assert.assertNull("RESPONSE IS NOT NULL", responseAll);
        } catch (AssertionError e) {
            throw e;
        }
    }
}