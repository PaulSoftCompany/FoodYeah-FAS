package com.paulsoft.food.services.impl;

import com.paulsoft.food.clients.UserClient;
import com.paulsoft.food.dtos.cardDto.CardDto;
import com.paulsoft.food.dtos.cardDto.CreateCardDto;
import com.paulsoft.food.entities.Card;
import com.paulsoft.food.exceptions.InternalServerErrorException;
import com.paulsoft.food.exceptions.NotFoundException;
import com.paulsoft.food.exceptions.ResourceException;
import com.paulsoft.food.models.Customer;
import com.paulsoft.food.repositories.CardRepository;
import com.paulsoft.food.services.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserClient userClient;

    public static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public List<CardDto> getCards() throws ResourceException {
        return convertToResources(cardRepository.findAll());
    }

    @Override
    public CardDto getCardById(Long id) throws ResourceException {
        return convertToResource(cardRepository.findById(id)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND")));    }

    @Override
    public List<CardDto> getAllByCustomerId(long id) throws ResourceException {
        // return convertToResources(cardRepository.findAllByCustomerId(id));
        return null;
    }

    @Override
    public CardDto createCard(CreateCardDto createCardDto) throws ResourceException {
        if(cardRepository.findCardByCardNumber(createCardDto.getCardNumber()).isPresent()){
            throw new InternalServerErrorException("CARD EXISTS", "CARD EXISTS");
        }
        Card card = new Card();
        Customer customer = userClient.getCustomerById(createCardDto.getCustomerId()).getData();

        card.setCustomer(customer);
        card.setCardMoney(createCardDto.getCardMoney());
        card.setCardNumber(createCardDto.getCardNumber());
        card.setExpireDate(createCardDto.getExpireDate());
        card.setType(createCardDto.getType());
        card.setOwner(createCardDto.getOwner());
        card.setState(true);
        return convertToResource(cardRepository.save(card));    }

    @Override
    public String deleteCard(Long id) throws ResourceException {
        Card card = cardRepository.findById(id)
                .orElseThrow(()->new NotFoundException("NOT_FOUND","NOT_FOUND"));
        card.setState(false);
        cardRepository.save(card);
        return card.getCardNumber().toString();
    }
    private Card getCardEntity(Long id) throws ResourceException {
        return cardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    private List<CardDto> convertToResources(List<Card> cards) {
        return cards.stream().map(x -> modelMapper.map(x, CardDto.class)).collect(Collectors.toList());
    }
    private Card convertToEntity(CreateCardDto resource){return  modelMapper.map(resource, Card.class);}

    private CardDto convertToResource(Card entity){return  modelMapper.map(entity,CardDto.class);}
}
