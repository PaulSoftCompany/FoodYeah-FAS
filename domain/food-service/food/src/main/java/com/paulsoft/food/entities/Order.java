package com.paulsoft.food.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.paulsoft.food.models.Customer;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Column(name ="total_price")
    private Double totalPrice;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    private List<OrderDetail> details;

    @Transient
    private Customer customer;
}