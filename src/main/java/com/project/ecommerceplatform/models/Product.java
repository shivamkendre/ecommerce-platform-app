package com.project.ecommerceplatform.models;



import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@Entity(name = "products")
public class Product extends BaseModel {

    private String title;
    private String price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @Cascade(CascadeType.ALL)
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Rating> rating;
}
