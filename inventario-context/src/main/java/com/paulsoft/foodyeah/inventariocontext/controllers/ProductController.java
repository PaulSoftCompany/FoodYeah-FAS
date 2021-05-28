package com.paulsoft.foodyeah.inventariocontext.controllers;

import com.paulsoft.foodyeah.inventariocontext.dtos.CreateProductDto;
import com.paulsoft.foodyeah.inventariocontext.dtos.ProductDto;
import com.paulsoft.foodyeah.inventariocontext.entities.Product;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceResponse;
import com.paulsoft.foodyeah.inventariocontext.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<Product>> getProducts() throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.getAll());
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<Product> getProductById(@PathVariable(name = "id") Long id) throws ResourceException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productService.getProductById(id));
    }


    private Product convertToEntity(CreateProductDto resource){ return mapper.map(resource,Product.class);}
    private ProductDto convertToResource(Product productCategory){return mapper.map(productCategory,ProductDto.class);}

}
