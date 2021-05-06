package com.paulsoft.foodyeah.foodcontext.model;

import com.paulsoft.foodyeah.foodcontext.entity.OrderDetail;
import lombok.Data;

import java.util.List;


@Data
public class Product {

    private Long id;

    private String name;

    private Double productPrice;

    private ProductCategory productCategory;

    private List<OrderDetail> orders;


}