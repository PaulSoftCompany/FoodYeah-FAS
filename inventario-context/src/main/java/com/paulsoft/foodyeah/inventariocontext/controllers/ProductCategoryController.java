package com.paulsoft.foodyeah.inventariocontext.controllers;

import com.paulsoft.foodyeah.inventariocontext.dtos.CreateProductCategoryDto;
import com.paulsoft.foodyeah.inventariocontext.dtos.ProductCategoryDto;
import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceResponse;
import com.paulsoft.foodyeah.inventariocontext.services.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/product-categories")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<ProductCategoryDto>> getProductCategories() throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productCategoryService.getAll().stream().map(this::convertToResource).collect(Collectors.toList()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<ProductCategoryDto> getProductCategoryById(@PathVariable(name = "id") Long id) throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                convertToResource(productCategoryService.getProductCategoryById(id)));
    }

    private ProductCategory convertToEntity(CreateProductCategoryDto resource){ return mapper.map(resource,ProductCategory.class);}
    private ProductCategoryDto convertToResource(ProductCategory productCategory){return mapper.map(productCategory,ProductCategoryDto.class);}
}
