package com.countries.backend.repository;

import com.countries.backend.entities.CountryAlias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryAliasRepository extends JpaRepository<CountryAlias, Integer> {}
