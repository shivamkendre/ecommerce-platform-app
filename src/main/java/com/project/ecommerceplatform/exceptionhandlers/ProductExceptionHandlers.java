package com.project.ecommerceplatform.exceptionhandlers;


import com.project.ecommerceplatform.dtos.ProductNotFoundDto;
import com.project.ecommerceplatform.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> productNotFoundDtoResponseEntity(){
        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setErrorId(1);
        productNotFoundDto.setErrorName("Product Not Found1!!");
        productNotFoundDto.setErrorDescription("Product Not Found!!");
        ResponseEntity<ProductNotFoundDto> response = new ResponseEntity<>(productNotFoundDto, HttpStatus.NOT_FOUND);
        return response;
    }
}
