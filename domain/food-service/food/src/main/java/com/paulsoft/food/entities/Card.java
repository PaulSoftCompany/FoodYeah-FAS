package com.paulsoft.food.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.paulsoft.food.models.Customer;

import lombok.Data;

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

    @Column(name = "expire_date")
    private Date expireDate;

    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Column(name = "card_money")
    private Double cardMoney;
}