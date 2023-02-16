package com.example.cryptocurrencies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppEntityNotFoundException extends RuntimeException {
    public AppEntityNotFoundException(String searchString) {
        super("Entity is not found, " + searchString);
    }

    public AppEntityNotFoundException(Integer id) {
        super("Entity is not found, id = " + id);
    }
}

