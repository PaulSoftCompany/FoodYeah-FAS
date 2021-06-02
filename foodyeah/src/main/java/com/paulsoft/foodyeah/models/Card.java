package com.paulsoft.foodyeah.models;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {

    private Long id;

    private Boolean type;

    private String owner;

    private Long cardNumber;

    private Date expireDate;

    private Boolean state;

    private Customer customer;

    private Double cardMoney;
}