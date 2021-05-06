package com.paulsoft.foodyeah.inventariocontext.controllers;

import com.paulsoft.foodyeah.inventariocontext.services.ProductCategoryService;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    //private ModelMapper mapper;
}
