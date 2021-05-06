package com.paulsoft.foodyeah.foodcontext.service.impl;

import com.paulsoft.foodyeah.foodcontext.entity.Card;
import com.paulsoft.foodyeah.foodcontext.model.Customer;
import com.paulsoft.foodyeah.foodcontext.repository.CardRepository;
import com.paulsoft.foodyeah.foodcontext.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public List<Card> findCardAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Long id) {
        return cardRepository.findById(id).orElse(null);
    }


    @Override
    public Card deleteCard(Long id) {
        Card cardDB=this.getCard(id);
        if(cardDB==null){
            return null;
        }
        cardDB.setState("DELETED");
        return cardRepository.save(cardDB);
    }
}