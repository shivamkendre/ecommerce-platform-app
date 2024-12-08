package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.dtos.FakeStoreApiDto;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;
import com.project.ecommerceplatform.util.DtoToModelConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreApiProductService implements ProductService{


    private RestTemplate restTemplate;
    private DtoToModelConverter dtoToModelConverter;

    public FakeStoreApiProductService(RestTemplate restTemplate, DtoToModelConverter dtoToModelConverter) {
        this.restTemplate = restTemplate;
        this.dtoToModelConverter = dtoToModelConverter;
    }


    @Override
    public Product getProductWithId(int id) throws ProductNotFoundException {
        FakeStoreApiDto fakeStoreApiDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreApiDto.class);
        if(fakeStoreApiDto == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return dtoToModelConverter.convertFakeStoreApiToProduct(fakeStoreApiDto);
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }
}
