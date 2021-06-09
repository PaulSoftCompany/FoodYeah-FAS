package com.paulsoft.inventory.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.paulsoft.inventory.models.OrderDetail;

import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    private String name;

    @Column(name ="product_price")
    private Double productPrice;

    @Column(name ="sell_day")
    private Byte sellDay;

    @Column(name = "image_url")
    private String imageUrl;

    private Boolean state;

    @Column(name ="created_at")
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id",nullable = false)
    private ProductCategory productCategory;

    //@Transient
    //private List<OrderDetail> orders;


}