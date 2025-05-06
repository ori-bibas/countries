package com.countries.backend.service.country;

import com.countries.backend.exception.CountriesNotFoundException;
import com.countries.backend.mapper.CountryMapper;
import com.countries.backend.model.Country;
import com.countries.backend.pojo.dto.CountryDTO;
import com.countries.backend.pojo.response.CountryMetadataResponse;
import com.countries.backend.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryMetadataService {

    private final CountryRepository countryRepository;

    public CountryMetadataService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryMetadataResponse getCountryMetadata() {
        CountryMetadataResponse countryMetadataResponse = new CountryMetadataResponse();

        List<Country> countries = countryRepository.findAll();
        if (countries.isEmpty()) throw new CountriesNotFoundException("Countries is empty.");

        List<CountryDTO> countryDTOList = countries.stream().map(CountryMapper::toDTO).toList();
        countryMetadataResponse.setCountryCount(countryDTOList.size());
        countryMetadataResponse.setCountryList(countryDTOList);

        return countryMetadataResponse;
    }

}
