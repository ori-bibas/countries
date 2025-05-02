package com.countries.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", unique = true)
    private String countryName;

    @Column(name = "country_code", unique = true)
    private String countryCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CountryAlias> countryAliasList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<CountryAlias> getCountryAliasList() {
        return countryAliasList;
    }

    public void setCountryAliasList(List<CountryAlias> countryAliasList) {
        this.countryAliasList = countryAliasList;
    }

}
