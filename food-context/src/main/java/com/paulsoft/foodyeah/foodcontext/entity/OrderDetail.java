package com.paulsoft.foodyeah.foodcontext.entity;

import com.paulsoft.foodyeah.foodcontext.model.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private byte quantity;

    @Column(name ="unit_price")
    private Double unitPrice;

    @Column(name ="total_price")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
