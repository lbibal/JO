package com.example.jo.meteo.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;

public interface CityService {
    String getWeatherForAllCities() throws URISyntaxException, JsonProcessingException;
}
