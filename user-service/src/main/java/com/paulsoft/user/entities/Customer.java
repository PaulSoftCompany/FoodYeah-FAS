package com.paulsoft.user.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.paulsoft.user.models.Card;
import com.paulsoft.user.models.Order;

import lombok.Data;


@Data
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    @Column(name="first_name", length=40)
    private String firstName;

    @Column(name ="last_name",length = 40)
    private String lastName;

    private String code;

    private Boolean state;

    private String password;

    @Column(name ="created_at")
    private Date createdAt;

    @Transient
    private List<Card> cards;

    @Transient
    private List<Order> orders;
}
