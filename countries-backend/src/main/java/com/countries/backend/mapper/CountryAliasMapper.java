package com.countries.backend.mapper;

import com.countries.backend.dto.CountryAliasDTO;
import com.countries.backend.model.CountryAlias;

public class CountryAliasMapper {

    public static CountryAliasDTO toDTO(CountryAlias countryAlias) {
        CountryAliasDTO countryAliasDTO = new CountryAliasDTO();
        countryAliasDTO.setCountryAlias(countryAlias.getCountryAlias());
        return countryAliasDTO;
    }

}
