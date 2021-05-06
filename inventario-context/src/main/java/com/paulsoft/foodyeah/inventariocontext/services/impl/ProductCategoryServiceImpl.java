package com.paulsoft.foodyeah.inventariocontext.services.impl;

import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import com.paulsoft.foodyeah.inventariocontext.exceptions.NotFoundException;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;
import com.paulsoft.foodyeah.inventariocontext.repositories.ProductCategoryRepository;
import com.paulsoft.foodyeah.inventariocontext.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAll() throws ResourceException {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(Long id) throws ResourceException {
        return productCategoryRepository.findById(id).orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) throws ResourceException {
        return productCategoryRepository.findByName(name).orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) throws ResourceException {
        if(productCategoryRepository.findByName(productCategory.getName()).isPresent()){
            throw new NotFoundException("PRODUCT_CATEGORY_EXISTS","PRODUCT_CATEGORY_EXISTS");
        }
        productCategory.setState("CREATED");
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) throws ResourceException {
        ProductCategory productCategoryDB = getProductCategoryByName(productCategory.getName());
        if (productCategoryDB == null) {
            throw new NotFoundException("NOT_FOUND","NOT_FOUND");
        }
        productCategoryDB.setName(productCategory.getName());
        productCategoryDB.setDescription(productCategory.getDescription());
        productCategoryDB.setState("UPDATED");
        return productCategoryRepository.save(productCategoryDB);
    }

    @Override
    public ProductCategory deleteProductCategory(Long id) throws ResourceException {
        ProductCategory productCategoryDB = getProductCategoryById(id);
        if (productCategoryDB == null) {
            throw new NotFoundException("NOT_FOUND","NOT_FOUND");
        }
        productCategoryDB.setState("DELETED");
        return productCategoryRepository.save(productCategoryDB);
    }
}
