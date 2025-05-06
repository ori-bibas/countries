package com.countries.backend.pojo.response;

import com.countries.backend.pojo.dto.CountryDTO;

import java.util.List;

public class CountryMetadataResponse {

    private int countryCount;
    private List<CountryDTO> countryList;

    public CountryMetadataResponse() {}

    public CountryMetadataResponse(int countryCount, List<CountryDTO> countryList) {
        this.countryCount = countryCount;
        this.countryList = countryList;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

}
