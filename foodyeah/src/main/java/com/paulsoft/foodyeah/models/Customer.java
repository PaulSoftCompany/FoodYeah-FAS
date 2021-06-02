package com.paulsoft.foodyeah.models;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;

    private String firstName;

    private String lastName;

    private String code;

    private Boolean state;

    private String password;

    private Date createdAt;

    private List<Card> cards;

    private List<Order> orders;

}