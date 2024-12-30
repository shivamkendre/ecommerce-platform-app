package com.project.ecommerceplatform.exceptionhandlers;


import com.project.ecommerceplatform.dtos.ProductSaveErrorDto;
import com.project.ecommerceplatform.dtos.ResourceNotFoundDto;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import com.project.ecommerceplatform.exceptions.ProductSaveException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDto> productNotFoundDtoResponseEntity(){
        ResourceNotFoundDto resourceNotFoundDto = new ResourceNotFoundDto();
        resourceNotFoundDto.setErrorId(1);
        resourceNotFoundDto.setErrorName("Product Not Found1!!");
        resourceNotFoundDto.setErrorDescription("Product Not Found!!");
        ResponseEntity<ResourceNotFoundDto> response = new ResponseEntity<>(resourceNotFoundDto, HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler(ProductSaveException.class)
    public ResponseEntity<ProductSaveErrorDto> productSaveExceptionResponseEntity(){
        ProductSaveErrorDto productSaveErrorDto = new ProductSaveErrorDto();
        productSaveErrorDto.setErrorId(2);
        productSaveErrorDto.setDescription("Error while saving record!!");
        return new ResponseEntity<>(productSaveErrorDto, HttpStatus.BAD_REQUEST);
    }

}
