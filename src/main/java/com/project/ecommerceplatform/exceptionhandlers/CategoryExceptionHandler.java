package com.project.ecommerceplatform.exceptionhandlers;

import com.project.ecommerceplatform.dtos.ResourceNotFoundDto;
import com.project.ecommerceplatform.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDto> handleCategoryNotFound(){
        ResourceNotFoundDto resourceNotFoundDto = new ResourceNotFoundDto();
        resourceNotFoundDto.setErrorId(2);
        resourceNotFoundDto.setErrorName("Category Not Found1!!");
        resourceNotFoundDto.setErrorDescription("Category Not Found!!");
        ResponseEntity<ResourceNotFoundDto> response = new ResponseEntity<>(resourceNotFoundDto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
