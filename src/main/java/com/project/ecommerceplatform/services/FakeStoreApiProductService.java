package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.dtos.FakeStoreApiDto;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;
import com.project.ecommerceplatform.util.DtoToModelConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Product> getProducts() throws ProductNotFoundException{
        FakeStoreApiDto[] fakeStoreListApiDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreApiDto[].class);
        if(fakeStoreListApiDto == null) {
            throw new ProductNotFoundException("Products not found!!");
        }
        return  Arrays.stream(fakeStoreListApiDto).map(fakeStoreApiDto -> dtoToModelConverter.convertFakeStoreApiToProduct(fakeStoreApiDto)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }



    @Override
    public Product updateProduct(int id, Product product) throws ProductNotFoundException {
        product = restTemplate.patchForObject("https://fakestoreapi.com/products/" + product.getId(), product, Product.class);
        if(product == null) {
            throw new ProductNotFoundException("Product Not Found!!");
        }
        return product;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }
}
