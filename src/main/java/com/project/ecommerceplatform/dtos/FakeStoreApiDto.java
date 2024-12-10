package com.project.ecommerceplatform.dtos;

import com.project.ecommerceplatform.models.Rating;
import lombok.Data;

@Data
public class FakeStoreApiDto {
    private int id;
    private String title;
    private String price;
    private String category;
    private String description;
    private Rating rating;

}