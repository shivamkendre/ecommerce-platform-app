package com.project.ecommerceplatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category extends BaseModel {

    String name;
    String description;
//    @OneToMany(mappedBy = "category")
//    List<Product> products;
}
