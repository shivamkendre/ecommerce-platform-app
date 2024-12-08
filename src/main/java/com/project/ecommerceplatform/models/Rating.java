package com.project.ecommerceplatform.models;

import lombok.Data;

@Data
public class Rating {
    private double rate;
    private int count;

    public double getRate() {
        return rate;
    }

    public int getCount() {
        return count;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
