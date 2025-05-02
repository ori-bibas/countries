package com.countries.backend.controller;

import com.countries.backend.dto.CountryDTO;
import com.countries.backend.mapper.CountryMapper;
import com.countries.backend.model.Country;
import com.countries.backend.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOList = countryList.stream().map(CountryMapper::toDTO).toList();
        return new ResponseEntity<>(countryDTOList, HttpStatus.OK);
    }

}
