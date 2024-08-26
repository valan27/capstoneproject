package org.example.capstoneproject.product.controller;

import org.example.capstoneproject.customer.dto.ErrorResponse;
import org.example.capstoneproject.product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerProduct {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ProductNotFoundException.class})
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException t){
        return new ErrorResponse(400,t.toString());

    }
}
