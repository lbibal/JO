package com.example.jo.country.controller;

import com.example.jo.country.persistence.Country;
import com.example.jo.country.service.CountryDataProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CountryController {

    private final CountryDataProvider countryDataProvider;
    private final ObjectMapper objectMapper;

    @Autowired
    public CountryController(CountryDataProvider countryDataProvider, ObjectMapper objectMapper) {
        this.countryDataProvider = countryDataProvider;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/country")
    public String getCountry(@RequestParam String countryCode) {
        try {
            Country country = countryDataProvider.getCountryByCode(countryCode);
            return objectMapper.writeValueAsString(country);
        } catch (IOException | InterruptedException e) {
            // Gérer l'erreur appropriée ou renvoyer une réponse d'erreur
            return "Une erreur s'est produite lors de la récupération des informations du pays.";
        }
    }

    @GetMapping("/countries")
    public String getCountries() {
        try {
            List<Country> countries = countryDataProvider.getCountries();
            return objectMapper.writeValueAsString(countries);
        } catch (IOException | InterruptedException e) {
            // Gérer l'erreur appropriée ou renvoyer une réponse d'erreur
            return "Une erreur s'est produite lors de la récupération de la liste des pays participants.";
        }
    }
}