package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.exceptions.CategoryNotFoundException;
import com.project.ecommerceplatform.exceptions.NoAuditDataAvailableException;
import com.project.ecommerceplatform.exceptions.ProductSaveException;
import com.project.ecommerceplatform.models.Category;
import com.project.ecommerceplatform.repos.CategoryRepo;
import com.project.ecommerceplatform.util.AuditDataUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private AuditDataUtils auditDataUtils;
    private CategoryRepo categoryRepo;

    public CategoryService(AuditDataUtils auditDataUtils, CategoryRepo categoryRepo) {
        this.auditDataUtils = auditDataUtils;
        this.categoryRepo = categoryRepo;
    }

    public Category updateCategory(Category updatedCategory) throws CategoryNotFoundException, ProductSaveException, NoAuditDataAvailableException {
        Optional<Category> categoryOptional = categoryRepo.findById(updatedCategory.getId());
        if(categoryOptional.isEmpty()){
            throw new CategoryNotFoundException("Category Id does not exist!!");
        }
        Category category = categoryOptional.get();
        copyUpdatedAttributes(category, updatedCategory);
        return category;
    }


    private void copyUpdatedAttributes(Category category, Category updatedCategory){
        if(updatedCategory.getName() != null)
            category.setName(updatedCategory.getName());
        if(updatedCategory.getDescription() != null)
            category.setDescription(updatedCategory.getDescription());
    }
}
