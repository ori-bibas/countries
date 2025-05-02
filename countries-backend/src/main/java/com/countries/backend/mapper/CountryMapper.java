package com.countries.backend.mapper;

import com.countries.backend.dto.CountryAliasDTO;
import com.countries.backend.dto.CountryDTO;
import com.countries.backend.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryMapper {

    public static CountryDTO toDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryName(country.getCountryName());
        countryDTO.setCountryCode(country.getCountryCode());

        List<CountryAliasDTO> countryAliasDTOList = new ArrayList<>();
        country.getCountryAliasList().forEach(countryAlias -> {
            CountryAliasDTO countryAliasDTO = CountryAliasMapper.toDTO(countryAlias);
            countryAliasDTOList.add(countryAliasDTO);
        });
        countryDTO.setCountryAliases(countryAliasDTOList);

        return countryDTO;
    }

}
