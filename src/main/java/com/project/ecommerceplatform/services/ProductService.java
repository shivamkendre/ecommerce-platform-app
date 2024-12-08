package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductWithId(int id) throws ProductNotFoundException;
    public List<Product> getProducts();
    public List<Product> getProductsByCategory(String category);
    public Product updateProduct(Product product);
    public boolean deleteProduct(Product product);

}
