package com.countries.backend.pojo.dto;

public class CountryAliasDTO {

    private String countryAlias;

    public CountryAliasDTO() {}

    public CountryAliasDTO(String countryAlias) {
        this.countryAlias = countryAlias;
    }

    public String getCountryAlias() {
        return countryAlias;
    }

    public void setCountryAlias(String countryAlias) {
        this.countryAlias = countryAlias;
    }

}
