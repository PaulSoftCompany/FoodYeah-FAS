package com.paulsoft.foodyeah.dtos;

import com.paulsoft.foodyeah.entities.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String code;
    private Boolean state;
    List<Card> registeredCards;
}
