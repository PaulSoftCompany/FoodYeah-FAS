package com.paulsoft.user.exceptions;

import java.util.Arrays;

import com.paulsoft.user.dtos.ErrorDto;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ResourceException{
    public NotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String code,  String message, ErrorDto data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}
