package com.example.jo.country.service;

import com.example.jo.country.persistence.Country;

import java.io.IOException;
import java.util.List;

public interface CountryDataProvider {
    List<Country> getCountries() throws IOException, InterruptedException;

    Country getCountryByCode(String countryCode) throws IOException, InterruptedException;
}