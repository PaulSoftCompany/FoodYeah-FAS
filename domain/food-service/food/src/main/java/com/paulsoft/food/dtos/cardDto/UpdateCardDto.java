package com.paulsoft.food.dtos.cardDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateCardDto {
    private Boolean type;
    private String owner;
    private Long cardNumber;
    private Date expireDate;
    private Long customerId;
    private Double cardMoney;
}
