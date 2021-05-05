package com.paulsoft.foodyeah.inventariocontext.services;

import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getAll() throws ResourceException;
    ProductCategory getProductCategoryById(Long id) throws ResourceException;
    ProductCategory getProductCategoryByName(String name) throws ResourceException;
    ProductCategory createProductCategory(ProductCategory productCategory) throws ResourceException;
    ProductCategory updateProductCategory(ProductCategory productCategory) throws ResourceException;
    ProductCategory deleteProductCategory(Long id) throws ResourceException;
}
