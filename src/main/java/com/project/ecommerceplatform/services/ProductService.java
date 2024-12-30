package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.exceptions.CategoryNotFoundException;
import com.project.ecommerceplatform.exceptions.NoAuditDataAvailableException;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.exceptions.ProductSaveException;
import com.project.ecommerceplatform.models.Product;

import java.util.List;

public interface ProductService {


    Product getProductWithId(long id) throws ProductNotFoundException;

    public List<Product> getProducts() throws ProductNotFoundException;
    public List<Product> getProductsByCategory(String category);
    public Product replaceProduct(int id, Product product) throws ProductNotFoundException;
    public Product updateProduct(int id, Product product) throws ProductNotFoundException;
    public Product deleteProduct(int id) throws ProductNotFoundException;
    public Product createProduct(Product product) throws ProductSaveException, CategoryNotFoundException, NoAuditDataAvailableException;
}
