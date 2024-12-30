package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.exceptions.CategoryNotFoundException;
import com.project.ecommerceplatform.exceptions.NoAuditDataAvailableException;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.exceptions.ProductSaveException;
import com.project.ecommerceplatform.models.Category;
import com.project.ecommerceplatform.models.Product;
import com.project.ecommerceplatform.repos.CategoryRepo;
import com.project.ecommerceplatform.repos.ProductRepo;
import com.project.ecommerceplatform.util.AuditDataUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryService categoryService;


    private AuditDataUtils auditDataUtils;

    public SelfProductService(ProductRepo productRepo, CategoryService categoryService, AuditDataUtils auditDataUtils) {
        this.productRepo = productRepo;
        this.categoryService = categoryService;
        this.auditDataUtils = auditDataUtils;
    }



    @Override
    public Product getProductWithId(long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isEmpty())
            throw new ProductNotFoundException("Product Not Found!!");

        return productOptional.get();
    }

    @Override
    public List<Product> getProducts() throws ProductNotFoundException {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public Product replaceProduct(int id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product deleteProduct(int id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) throws ProductSaveException, CategoryNotFoundException, NoAuditDataAvailableException {



        Category category = product.getCategory();
        if(category.getId() == null){
            auditDataUtils.setCreationData(category);
        }else {
           product.setCategory(categoryService.updateCategory(category));
           auditDataUtils.setUpdationData(product.getCategory());
        }

        auditDataUtils.setCreationData(product);
        return productRepo.save(product);
    }
}
