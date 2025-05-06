package com.countries.backend.exception;

public class CountriesNotFoundException extends RuntimeException {
    public CountriesNotFoundException(String message) {
        super(message);
    }
}
