package com.countries.backend.repository;

import com.countries.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c LEFT JOIN c.countryAliasList a WHERE LOWER(c.countryName) = LOWER(:countryName) OR LOWER(a.countryAlias) = LOWER(:countryName)")
    Country findCountryByNameOrAlias(@Param("countryName") String countryName);

}
