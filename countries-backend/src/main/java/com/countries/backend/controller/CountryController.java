package com.countries.backend.controller;

import com.countries.backend.dto.CountryDTO;
import com.countries.backend.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<CountryDTO> countryDTOList = countryService.findAllCountries();
        return new ResponseEntity<>(countryDTOList, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
        CountryDTO countryDTO = countryService.findCountryById(id);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CountryDTO> getCountryByName(@PathVariable String name) {
        CountryDTO countryDTO = countryService.findCountryByName(name);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

}
