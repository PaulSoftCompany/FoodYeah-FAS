package com.paulsoft.inventory.controllers

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.paulsoft.inventory.services.ProductCategoryService;
import com.paulsoft.inventory.dtos.ProductCategoryDto.CreateProductCategoryDto;
import com.paulsoft.inventory.dtos.ProductCategoryDto.ProductCategoryDto;
import com.paulsoft.inventory.dtos.ProductCategoryDto.UpdateProductCategoryDto;
import com.paulsoft.inventory.exceptions.ResourceException;
import com.paulsoft.inventory.responses.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product_categories")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResourceResponse<List<ProductCategoryDto>> getProductCategories() throws ResourceException {
        return new ResourceResponse<>("Success", String.valueOf(HttpStatus.OK),"OK"
                    ,productCategoryService.getProductCategories());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResourceResponse<ProductCategoryDto> getProductCategoryById(@PathVariable("id") Long id) throws ResourceException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productCategoryService.getProductCategoryById(id));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResourceResponse<ProductCategoryDto> createProductCategory(@RequestBody @Valid CreateProductCategoryDto createProductCategoryDto) throws ResourceException, ParseException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productCategoryService.createProductCategory(createProductCategoryDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResourceResponse<ProductCategoryDto> updateProductCategory(@RequestBody @Valid UpdateProductCategoryDto updateProductCategoryDto,@PathVariable("id") Long id) throws ResourceException{
        return new ResourceResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                productCategoryService.updateProductCategory(updateProductCategoryDto,id));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResourceResponse<String> deleteProductCategory(@PathVariable("id") Long id) throws ResourceException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productCategoryService.deleteProductCategory(id));
    }
}
