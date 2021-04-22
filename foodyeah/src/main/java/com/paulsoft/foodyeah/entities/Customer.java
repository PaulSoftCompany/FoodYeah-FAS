package com.paulsoft.foodyeah.entities;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="customers")
public class Customer{
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

    @ManyToMany
    @JoinTable(name = "card_registered",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    List<Card> registeredCards;

}