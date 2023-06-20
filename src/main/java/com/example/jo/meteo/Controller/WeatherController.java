package com.example.jo.meteo.Controller;

import com.example.jo.meteo.Service.API.WeatherApiInterface;
import com.example.jo.meteo.Service.Serializer.WeatherJsonSerializerService;
import com.example.jo.meteo.Service.Serializer.WeatherSerializerInterface;
import com.example.jo.meteo.Service.API.WeatherApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
@RestController
public class WeatherController {
    //one for a specific city (obviously in city available)

    private final WeatherApiInterface weatherApiService;

    public WeatherController(WeatherApiInterface weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) throws URISyntaxException, JsonProcessingException {
        String jsonString = weatherApiService.getWeatherForCity(city);
        WeatherSerializerInterface weatherSerializer = new WeatherJsonSerializerService();
        String partialWeatherJson = weatherSerializer.partialWeatherJson(jsonString);
        return partialWeatherJson;
    }

    //for all city retrieve from db
}
