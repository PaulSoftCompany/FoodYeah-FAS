package com.example.foodcontext.model;

import com.example.foodcontext.entity.OrderDetail;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
public class Product {

    private Long id;

    private String name;

    private Double productPrice;

    private ProductCategory productCategory;

    private List<OrderDetail> orders;


}