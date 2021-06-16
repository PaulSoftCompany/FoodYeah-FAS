package com.paulsoft.food.controllers;

import com.paulsoft.food.dtos.cardDto.CardDto;
import com.paulsoft.food.dtos.cardDto.CreateCardDto;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.responses.ResourceResponse;
import com.paulsoft.food.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
    @Autowired
    CardService cardService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("cards")
    public ResourceResponse<List<CardDto>> getCards() throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                cardService.getCards());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("cards")
    public ResourceResponse<CardDto> createCard(@RequestBody @Valid CreateCardDto createCardDto ) throws ResourceException, ParseException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                cardService.createCard(createCardDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("customers/{customerId}/cards")
    public ResourceResponse<List<CardDto>> getCardsByCustomerId(@PathVariable("customerId") Long customerId) throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                cardService.getAllByCustomerId(customerId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("cards/{cardId}")
    public ResourceResponse<CardDto> getCardById(@PathVariable("cardId") Long cardId) throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                cardService.getCardById(cardId));
    }
}
