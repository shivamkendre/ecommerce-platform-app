package com.project.ecommerceplatform.services;

import com.project.ecommerceplatform.dtos.FakeStoreApiDto;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.models.Product;
import com.project.ecommerceplatform.util.DtoToModelConverter;
import com.project.ecommerceplatform.util.ModelToDtoConverter;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("fakeStoreProductService")
public class FakeStoreApiProductService implements ProductService {


    private RestTemplate restTemplate;
    private DtoToModelConverter dtoToModelConverter;
    private ModelToDtoConverter modelToDtoConverter;


    public FakeStoreApiProductService(RestTemplate restTemplate, DtoToModelConverter dtoToModelConverter, ModelToDtoConverter modelToDtoConverter) {
        this.restTemplate = restTemplate;
        this.dtoToModelConverter = dtoToModelConverter;
        this.modelToDtoConverter = modelToDtoConverter;
    }


    @Override
    public Product getProductWithId(long id) throws ProductNotFoundException {
        FakeStoreApiDto fakeStoreApiDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreApiDto.class);
        if (fakeStoreApiDto == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return dtoToModelConverter.convertFakeStoreApiToProduct(fakeStoreApiDto);
    }

    @Override
    public List<Product> getProducts() throws ProductNotFoundException {
        FakeStoreApiDto[] fakeStoreListApiDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreApiDto[].class);
        if (fakeStoreListApiDto == null) {
            throw new ProductNotFoundException("Products not found!!");
        }
        return Arrays.stream(fakeStoreListApiDto).map(fakeStoreApiDto -> dtoToModelConverter.convertFakeStoreApiToProduct(fakeStoreApiDto)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public Product replaceProduct(int id, Product product) throws ProductNotFoundException {
        FakeStoreApiDto fakeStoreApiDto = modelToDtoConverter.convertProductToFakeStoreApiDto(product);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreApiDto);
        ResponseExtractor<ResponseEntity<FakeStoreApiDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreApiDto.class);
        ResponseEntity<FakeStoreApiDto> response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        System.out.println(response.getHeaders());
        return dtoToModelConverter.convertFakeStoreApiToProduct(response.getBody());
    }


    @Override
    public Product updateProduct(int id, Product product) throws ProductNotFoundException {
        product = restTemplate.patchForObject("https://fakestoreapi.com/products/" + product.getId(), product, Product.class);
        if (product == null) {
            throw new ProductNotFoundException("Product Not Found!!");
        }
        return product;
    }

    @Override
    public Product deleteProduct(int id) throws ProductNotFoundException {


        FakeStoreApiDto fakeStoreApiDto = (FakeStoreApiDto) restTemplate
                .execute("https://fakestoreapi.com/products/" + id, HttpMethod.DELETE, null, restTemplate.responseEntityExtractor(FakeStoreApiDto.class))
                .getBody();
        if(fakeStoreApiDto == null) {
            throw new ProductNotFoundException("Product not found!");
        }
        return dtoToModelConverter.convertFakeStoreApiToProduct(fakeStoreApiDto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
