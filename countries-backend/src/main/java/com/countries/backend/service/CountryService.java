package com.countries.backend.service;

import com.countries.backend.dto.CountryDTO;
import com.countries.backend.exception.CountryNotFoundException;
import com.countries.backend.mapper.CountryMapper;
import com.countries.backend.model.Country;
import com.countries.backend.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> findAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDTO> countryDTOList = countries.stream()
                .map(CountryMapper::toDTO)
                .toList();

        logger.debug("Found {} countries.", countryDTOList.size());
        return countryDTOList;
    }

    public CountryDTO findCountryById(Long id) {
        Country country = countryRepository.findById(id).orElse(null);
        if (country == null) {
            logger.debug("Country with id {} not found.", id);
            throw new CountryNotFoundException();
        }

        return CountryMapper.toDTO(country);
    }

    public CountryDTO findCountryByName(String countryName) {
        Country country = countryRepository.findCountryByNameOrAlias(countryName);
        if (country == null) {
            logger.debug("Country with name {} not found.", countryName);
            throw new CountryNotFoundException();
        }

        return CountryMapper.toDTO(country);
    }

}
