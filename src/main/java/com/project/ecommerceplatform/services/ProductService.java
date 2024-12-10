package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductWithId(int id) throws ProductNotFoundException;
    public List<Product> getProducts() throws ProductNotFoundException;
    public List<Product> getProductsByCategory(String category);


    Product updateProduct(int id, Product product) throws ProductNotFoundException;

    public boolean deleteProduct(Product product);

}
