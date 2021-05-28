package com.paulsoft.foodyeah.inventariocontext.services.impl;

import com.paulsoft.foodyeah.inventariocontext.entities.Product;
import com.paulsoft.foodyeah.inventariocontext.entities.ProductCategory;
import com.paulsoft.foodyeah.inventariocontext.exceptions.NotFoundException;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;
import com.paulsoft.foodyeah.inventariocontext.repositories.ProductCategoryRepository;
import com.paulsoft.foodyeah.inventariocontext.repositories.ProductRepository;
import com.paulsoft.foodyeah.inventariocontext.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<Product> getAll() throws ResourceException {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ResourceException {
        return productRepository.findById(id).orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    @Override
    public Product getProductByName(String name) throws ResourceException {
        return productRepository.findByName(name).orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
    }

    @Override
    public List<Product> getProductBySellday(int sellDay) throws ResourceException {
        return productRepository.findBySellday(sellDay);
    }

    @Override
    public List<Product> getProductByProductCategoryId(long id) throws ResourceException {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(()-> new NotFoundException("NOT_FOUND","NOT_FOUND"));
        return productRepository.findByProductCategory(productCategory);
    }

    @Override
    public List<Product> menuSemanal() throws ResourceException {
        return productRepository.menuSemanal();
    }

    @Override
    public List<Product> platosALaCarta() throws ResourceException {
        return productRepository.platosALaCarta();
    }

    @Override
    public List<Product> platosALaCartaByCategoryId(long id) throws ResourceException {
        return productRepository.platosALaCartaByCategory(id);
    }

    @Override
    public Product createProduct(Product product) throws ResourceException {
        if(productRepository.findByName(product.getName()).isPresent()){
            throw new NotFoundException("PRODUCT_EXISTS","PRODUCT_EXISTS");
        }
        product.setState("CREATED");
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ResourceException {
        Product productDB = getProductByName(product.getName());
        if(productDB == null){
            throw new NotFoundException("NOT_FOUND","NOT_FOUND");
        }
        productDB.setProductCategory(product.getProductCategory());
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());
        productDB.setSellday(product.getSellday());
        productDB.setStock(product.getStock());
        product.setIngredients(product.getIngredients());
        productDB.setState("UPDATED");
        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) throws ResourceException {
        Product productDB = getProductById(id);
        if(productDB == null){
            throw new NotFoundException("NOT_FOUND","NOT_FOUND");
        }
        productDB.setState("DELETED");
        return productRepository.save(productDB);
    }

}
