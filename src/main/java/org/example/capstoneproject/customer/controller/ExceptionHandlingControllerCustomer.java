package org.example.capstoneproject.customer.controller;

import org.example.capstoneproject.customer.dto.ErrorResponse;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerCustomer {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CustomerNotFoundException.class})
    public ErrorResponse handleCustomerNotFoundException(CustomerNotFoundException t){
        return new ErrorResponse(400,t.toString());

    }
}
