package com.paulsoft.foodyeah.foodcontext.entity;

import com.paulsoft.foodyeah.foodcontext.model.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="cards")
public class Card{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    private Boolean type;

    @Column(name="owner",length=40)
    private String owner;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "card_money")
    private float cardMoney;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "card_state")
    private String state;

    @ManyToMany(mappedBy = "registeredCards")
    List<Customer> customers;


}
