package com.countries.backend.pojo.dto;

import java.util.List;

public class CountryDTO {

    private String countryName;
    private String countryCode;
    private List<CountryAliasDTO> countryAliases;

    public CountryDTO() {}

    public CountryDTO(String countryName, String countryCode, List<CountryAliasDTO> countryAliases) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryAliases = countryAliases;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<CountryAliasDTO> getCountryAliases() {
        return countryAliases;
    }

    public void setCountryAliases(List<CountryAliasDTO> countryAliases) {
        this.countryAliases = countryAliases;
    }

}
