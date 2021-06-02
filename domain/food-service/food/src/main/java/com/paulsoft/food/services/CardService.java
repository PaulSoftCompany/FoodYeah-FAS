package com.paulsoft.food.services;

import com.paulsoft.food.dtos.cardDto.CardDto;
import com.paulsoft.food.dtos.cardDto.CreateCardDto;
import com.paulsoft.food.exceptions.ResourceException;

import java.util.List;

public interface CardService {
    List<CardDto> getCards() throws ResourceException;

    CardDto getCardById(Long id) throws ResourceException;

    List<CardDto> getAllByCustomerId(long id) throws ResourceException;

    CardDto createCard(CreateCardDto createCardDto) throws ResourceException;

    String deleteCard(Long id) throws ResourceException;
}
