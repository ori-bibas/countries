package com.countries.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "country_alias")
public class CountryAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alias_name")
    private String countryAlias;

    @ManyToOne
    @JoinColumn(name = "fk_country_id", nullable = false)
    @JsonBackReference
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryAlias() {
        return countryAlias;
    }

    public void setCountryAlias(String countryAlias) {
        this.countryAlias = countryAlias;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
