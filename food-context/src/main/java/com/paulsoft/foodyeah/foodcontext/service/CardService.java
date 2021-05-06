package com.paulsoft.foodyeah.foodcontext.service;


import com.paulsoft.foodyeah.foodcontext.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> findCardAll();
    Card getCard(Long id);



    Card deleteCard(Long id);
}
