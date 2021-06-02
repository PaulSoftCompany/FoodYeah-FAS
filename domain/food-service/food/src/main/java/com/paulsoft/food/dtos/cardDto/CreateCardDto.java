package com.paulsoft.food.dtos.cardDto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCardDto {
    private Boolean type;
    private String owner;
    private Long cardNumber;
    private Date expireDate;
    private Long customerId;
    private Double cardMoney;
}
