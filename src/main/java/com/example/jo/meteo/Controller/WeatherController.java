package com.example.jo.meteo.Controller;

import com.example.jo.meteo.Persistence.Entity.City;
import com.example.jo.meteo.Persistence.Repository.CityRepository;
import com.example.jo.meteo.Service.API.WeatherApiInterface;
import com.example.jo.meteo.Service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
@RestController
public class WeatherController {
    private final WeatherApiInterface weatherApiService;
    private final CityService cityService;
    public WeatherController(WeatherApiInterface weatherApiService,
                             CityService cityService) {
        this.weatherApiService = weatherApiService;
        this.cityService = cityService;
    }
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) throws URISyntaxException, JsonProcessingException {
        return weatherApiService.getWeatherForCity(city);
    }
    @GetMapping("/weather/cities")
    public String getWeatherForAllCities() throws URISyntaxException, JsonProcessingException {
        return cityService.getWeatherForAllCities();
    }

}
