package com.project.ecommerceplatform.dtos;


public class ProductNotFoundDto {
    private int errorId;
    private String errorName;
    private String errorDescription;

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public int getErrorId() {
        return errorId;
    }

    public String getErrorName() {
        return errorName;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
