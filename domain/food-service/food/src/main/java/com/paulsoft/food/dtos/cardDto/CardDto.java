package com.paulsoft.food.dtos.cardDto;

import java.util.Date;

import com.paulsoft.food.models.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Long id;
    private Boolean type;
    private String owner;
    private Long cardNumber;
    private Date expireDate;
    private Customer customer;
    private Double cardMoney;
}
