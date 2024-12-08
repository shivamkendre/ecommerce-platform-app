package com.project.ecommerceplatform.models;




public class Product {
    private int id;
    private String title;
    private String price;
    private Category category;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }

    private Rating rating;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
