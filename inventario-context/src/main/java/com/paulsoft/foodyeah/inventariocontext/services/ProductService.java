package com.paulsoft.foodyeah.inventariocontext.services;

import com.paulsoft.foodyeah.inventariocontext.entities.Product;
import com.paulsoft.foodyeah.inventariocontext.exceptions.ResourceException;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws ResourceException;
    Product getProductById(Long id) throws ResourceException;
    Product getProductByName(String name) throws ResourceException;
    List<Product> getProductBySellday(int sellDay) throws ResourceException;
    List<Product> getProductByCategoryId(long id) throws ResourceException;
    List<Product> menuSemanal() throws ResourceException;
    List<Product> platosALaCarta() throws ResourceException;
    List<Product> platosALaCartaByCategoryId(long id) throws ResourceException;

    Product createProduct(Product product) throws ResourceException;
    Product updateProduct(Product product) throws ResourceException;
    Product deleteProduct(Long id) throws ResourceException;
}
