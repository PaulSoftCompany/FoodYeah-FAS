package com.paulsoft.inventory.exceptions;

import java.util.Arrays;

import com.paulsoft.inventory.dtos.ErrorDto;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ResourceException{
    public InternalServerErrorException(String code,  String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
