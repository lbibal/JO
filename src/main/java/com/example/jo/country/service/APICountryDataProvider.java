package com.example.jo.country.service;

import com.example.jo.country.persistence.Country;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class APICountryDataProvider implements CountryDataProvider {
    private final APIClient apiClient;

    public APICountryDataProvider(APIClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public List<Country> getCountries() throws IOException, InterruptedException {
        return apiClient.getCountries();
    }

    @Override
    public Country getCountryByCode(String countryCode) throws IOException, InterruptedException {
        return apiClient.getCountryByCode(countryCode);
    }
}