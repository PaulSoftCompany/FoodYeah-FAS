package com.paulsoft.foodyeah.inventariocontext.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    private String name;

    private Double price;

    private byte sellday;

    @Column(name = "image_url",nullable = false)
    private String imageUrl;

    private String[] ingredients;

    private int stock;

    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id",nullable = false)
    private ProductCategory productCategory;
}