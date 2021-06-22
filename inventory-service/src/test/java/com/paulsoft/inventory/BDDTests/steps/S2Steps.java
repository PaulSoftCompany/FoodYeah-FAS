package com.paulsoft.inventory.BDDTests.steps;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.paulsoft.inventory.dtos.ProductDto.CreateProductDto;
import com.paulsoft.inventory.dtos.ProductDto.ProductDto;
import com.paulsoft.inventory.dtos.ProductDto.UpdateProductDto;
import com.paulsoft.inventory.entities.Product;
import com.paulsoft.inventory.entities.ProductCategory;
import com.paulsoft.inventory.exceptions.NotFoundException;
import com.paulsoft.inventory.exceptions.ResourceException;
import com.paulsoft.inventory.repositories.ProductCategoryRepository;
import com.paulsoft.inventory.repositories.ProductRepository;
import com.paulsoft.inventory.services.impl.ProductServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class S2Steps {

    @InjectMocks
    ProductServiceImpl service;
    @Mock
    ProductRepository repository;
    @Mock
    ProductCategoryRepository categoryRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    private static final Product PRODUCT = new Product();
    private static final Long PRODUCT_ID = 1L;
    private static final String PRODUCT_NAME = "ProductoNombre";
    private static final Double PRODUCT_PRICE = 100.0;
    private static final Byte PRODUCT_SELLDAY = 1;
    private static final String PRODUCT_IMAGEURL = "https://gestion.pe/resizer/JQjqRhOR2c0U_-f_OPQdREYQRI4=/1200x800/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/DBQRWFS66VCUFHX2ODH6ITHJQI.jpg";
    private static final Boolean STATE_CREATED = true;
    private static final Boolean STATE_DELETED = false;
    private static final Date DATE = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

    private static final ProductCategory PRODUCT_CATEGORY = new ProductCategory();
    private static final Long PRODUCT_CATEGORY_ID = 1L;
    private static final String PRODUCT_CATEGORY_NAME = "CategoriaNombre";
    private static final String PRODUCT_CATEGORY_DESCRIPTION = "CategoriaDescripcion";
    List<ProductDto> responseAll;
    List<ProductDto> responseDate;

    @Given("a user2")
    public void aUser2() {
        MockitoAnnotations.openMocks(this);
        PRODUCT.setId(PRODUCT_ID);
        PRODUCT.setName(PRODUCT_NAME);
        PRODUCT.setProductPrice(PRODUCT_PRICE);
        PRODUCT.setSellDay(PRODUCT_SELLDAY);
        PRODUCT.setImageUrl(PRODUCT_IMAGEURL);
        PRODUCT.setCreatedAt(DATE);
        PRODUCT_CATEGORY.setId(PRODUCT_CATEGORY_ID);
        PRODUCT_CATEGORY.setName(PRODUCT_CATEGORY_NAME);
        PRODUCT_CATEGORY.setDescription(PRODUCT_CATEGORY_DESCRIPTION);
        PRODUCT.setProductCategory(PRODUCT_CATEGORY);
    }

    @When("loads the dishes a la carte")
    public void loadsTheDishesALaCarte() {
        Mockito.when(repository.findAllBySellDay(PRODUCT_SELLDAY)).thenReturn(Arrays.asList(PRODUCT));
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(PRODUCT));
        try {
            responseAll = service.getProducts();
            responseDate = service.getProductsBySellDay(PRODUCT_SELLDAY);
        } catch (ResourceException e) {
            System.out.println("SERVICE ERROR");
        }
    }

    @Then("the system shows the description of each dish")
    public void theSystemShowsTheDescriptionOfEachDish() {
        try {
            Assert.assertNotNull("RESPONSE NOT NULL", responseAll);
        } catch (AssertionError e) {
            throw e;
        }
    }

    @Then("the system shows the description of the filtered dish")
    public void theSystemShowsTheDescriptionOfTheFilteredDish() {
    }

    @Then("the system shows the description of each product")
    public void theSystemShowsTheDescriptionOfEachProduct() {
        try {
            Assert.assertNotNull("RESPONSE NOT NULL", responseDate);
        } catch (AssertionError e) {
            throw e;
        }
    }

    @Then("the system shows the product but without image")
    public void theSystemShowsTheProductButWithoutImage() {
        try {
            Assert.assertNotNull("RESPONSE NOT NULL", responseDate);
        } catch (AssertionError e) {
            throw e;
        }
    }

    private ProductDto convertToResource(Product entity) {
        return modelMapper.map(entity, ProductDto.class);
    }
}
