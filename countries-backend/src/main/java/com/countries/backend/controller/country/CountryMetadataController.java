package com.countries.backend.controller.country;

import com.countries.backend.pojo.response.CountryMetadataResponse;
import com.countries.backend.service.country.CountryMetadataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metadata/country")
public class CountryMetadataController {

    private final CountryMetadataService countryMetadataService;

    public CountryMetadataController(CountryMetadataService countryMetadataService) {
        this.countryMetadataService = countryMetadataService;
    }

    @GetMapping
    public ResponseEntity<CountryMetadataResponse> getCountryMetadata() {
        CountryMetadataResponse countryMetadataResponse = countryMetadataService.getCountryMetadata();
        return new ResponseEntity<>(countryMetadataResponse, HttpStatus.OK);
    }

}
