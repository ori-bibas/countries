package com.countries.backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "country_alias")
public class CountryAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "alias_name")
    private String countryAlias;

    @Column(name = "fk_country_id")
    private UUID fkCountryId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountryAlias() {
        return countryAlias;
    }

    public void setCountryAlias(String countryAlias) {
        this.countryAlias = countryAlias;
    }

    public UUID getFkCountryId() {
        return fkCountryId;
    }

    public void setFkCountryId(UUID fkCountryId) {
        this.fkCountryId = fkCountryId;
    }

}
