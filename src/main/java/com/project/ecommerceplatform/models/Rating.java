package com.project.ecommerceplatform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Rating  extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private double rate;
    private int temp;

}
