package org.example.capstoneproject.admin.controller;


import org.example.capstoneproject.admin.exception.AdminNotFoundException;
import org.example.capstoneproject.customer.dto.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlingControllerAdmin {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AdminNotFoundException.class})
    public ErrorResponse handleAdminNotFoundException(AdminNotFoundException t){
        return new ErrorResponse(400,t.toString());

    }
}
