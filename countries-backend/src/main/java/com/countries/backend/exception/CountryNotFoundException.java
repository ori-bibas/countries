package com.countries.backend.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException() {
        super("Country cannot be found.");
    }
}