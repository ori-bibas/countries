package com.countries.backend.helper;

public enum HealthConstants {

    API("API"),
    PERSISTENCE("PERSISTENCE"),
    OK("OK"),
    ERROR("ERROR");

    private final String key;

    HealthConstants(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
