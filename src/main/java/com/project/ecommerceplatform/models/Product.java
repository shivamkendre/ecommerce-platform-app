package com.project.ecommerceplatform.models;


import lombok.Data;

@Data
public class Product {
    private int id;
    private String title;
    private String price;
    private Category category;
}
