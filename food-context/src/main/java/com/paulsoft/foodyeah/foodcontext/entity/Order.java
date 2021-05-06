package com.paulsoft.foodyeah.foodcontext.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> products;


    @Valid
    @NotNull(message = "no puede estar vacío")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Column(name = "init_time")
    private String inittime;

    @Column(name = "end_Time")
    private String endtime;

    @Column(name = "order_state")
    public String state;
}
