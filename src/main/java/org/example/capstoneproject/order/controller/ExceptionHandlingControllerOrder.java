package org.example.capstoneproject.order.controller;

import org.example.capstoneproject.customer.dto.ErrorResponse;
import org.example.capstoneproject.customer.exception.CustomerNotFoundException;
import org.example.capstoneproject.order.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerOrder {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({OrderNotFoundException.class})
    public ErrorResponse handleOrderNotFoundException(OrderNotFoundException t){
        return new ErrorResponse(400,t.toString());

    }
}
