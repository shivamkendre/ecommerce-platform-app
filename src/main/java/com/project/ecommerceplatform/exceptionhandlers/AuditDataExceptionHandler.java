package com.project.ecommerceplatform.exceptionhandlers;

import com.project.ecommerceplatform.dtos.ResourceNotFoundDto;
import com.project.ecommerceplatform.exceptions.NoAuditDataAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuditDataExceptionHandler {

    @ExceptionHandler(NoAuditDataAvailableException.class)
    public ResponseEntity<ResourceNotFoundDto> handleCategoryNotFound(){
        ResourceNotFoundDto resourceNotFoundDto = new ResourceNotFoundDto();
        resourceNotFoundDto.setErrorId(3);
        resourceNotFoundDto.setErrorName("Audit Data Not Available!!");
        resourceNotFoundDto.setErrorDescription("Audit Data Not Available!!");
        ResponseEntity<ResourceNotFoundDto> response = new ResponseEntity<>(resourceNotFoundDto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
