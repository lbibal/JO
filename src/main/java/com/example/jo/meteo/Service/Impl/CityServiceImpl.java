package com.example.jo.meteo.Service.Impl;

import com.example.jo.meteo.Persistence.Entity.City;
import com.example.jo.meteo.Persistence.Repository.CityRepository;
import com.example.jo.meteo.Service.API.WeatherApiInterface;
import com.example.jo.meteo.Service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepo;
    private final WeatherApiInterface weatherApiService;
    private final List<String> listNameOfCity = new LinkedList<>();

    public CityServiceImpl(CityRepository cityRepo, WeatherApiInterface weatherApiService) {
        this.cityRepo = cityRepo;
        this.weatherApiService = weatherApiService;
    }

    public String getWeatherForAllCities() throws URISyntaxException, JsonProcessingException {
        retrieveNameOfCity();
        StringBuilder buildJsonOfAllCities = new StringBuilder();
        for(String city : listNameOfCity){
            buildJsonOfAllCities.append(weatherApiService.getWeatherForCity(city));
        }
        return buildJsonOfAllCities.toString();
    }
    private void retrieveNameOfCity(){
        for(City city : cityRepo.findAll()){
            this.listNameOfCity.add(city.getName());
        }
    }
}
