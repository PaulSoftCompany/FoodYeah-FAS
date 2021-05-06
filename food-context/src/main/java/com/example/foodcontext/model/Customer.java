package com.example.foodcontext.model;

import com.example.foodcontext.entity.Card;
import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String code;

    private Boolean state;

    List<Card> registeredCards;
}
