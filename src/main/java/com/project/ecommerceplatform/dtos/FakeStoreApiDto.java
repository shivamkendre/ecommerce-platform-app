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

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}