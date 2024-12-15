package com.project.ecommerceplatform.util;

import com.project.ecommerceplatform.dtos.FakeStoreApiDto;
import com.project.ecommerceplatform.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ModelToDtoConverter {

    public FakeStoreApiDto convertProductToFakeStoreApiDto(Product product) {
        FakeStoreApiDto fakeStoreApiDto = new FakeStoreApiDto();

        // Mapping fields from Product to FakeStoreApiDto
        fakeStoreApiDto.setId(product.getId());
        fakeStoreApiDto.setTitle(product.getTitle());
        fakeStoreApiDto.setPrice(product.getPrice());

        // Assuming Category is an Enum or another object and we convert it to string for category
        fakeStoreApiDto.setCategory(product.getCategory() != null ? product.getCategory().toString() : null);

        // Assuming there is no description in the Product model, set it as null or a default value
        fakeStoreApiDto.setDescription("No description available");  // You can change this depending on your requirements

        // You might want to map Rating here if it's needed from another place
        // For now, we can leave it null or provide a default Rating if required.
        fakeStoreApiDto.setRating(null); // You can map this if the Rating is in the Product model or elsewhere.

        return fakeStoreApiDto;
    }
}
