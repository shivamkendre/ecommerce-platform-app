package com.project.ecommerceplatform.util;

import com.project.ecommerceplatform.dtos.FakeStoreApiDto;
import com.project.ecommerceplatform.models.Category;
import com.project.ecommerceplatform.models.Product;
import org.springframework.stereotype.Component;

@Component
public class DtoToModelConverter {


    public Product convertFakeStoreApiToProduct(FakeStoreApiDto fakeStoreApiDto){
       Product product = new Product();
        product.setId(fakeStoreApiDto.getId());
        Category category = new Category();
        category.setName(fakeStoreApiDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreApiDto.getPrice());
        product.setTitle(fakeStoreApiDto.getTitle());
        return product;
    }

}
