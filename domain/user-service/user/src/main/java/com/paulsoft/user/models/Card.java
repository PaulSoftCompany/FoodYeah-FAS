package com.paulsoft.user.models;

import com.paulsoft.user.entities.Customer;
import lombok.Getter;

import java.util.Date;

@Getter
public class Card {

    private Long id;
    private Boolean type;
    private String owner;
    private Long cardNumber;
    private Date expireDate;
    private Customer customer;
    private Double cardMoney;
}
