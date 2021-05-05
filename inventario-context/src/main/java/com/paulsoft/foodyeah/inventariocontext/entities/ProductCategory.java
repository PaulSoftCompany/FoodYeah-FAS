package com.paulsoft.foodyeah.inventariocontext.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    private String name;

    private String description;

    public String state;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "productCategory")
    private List<Product> products;
}