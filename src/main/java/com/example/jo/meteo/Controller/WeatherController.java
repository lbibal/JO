package com.example.jo.meteo.Controller;

import com.example.jo.meteo.Persistence.Meteo;
import com.example.jo.meteo.Service.API.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
@SpringBootApplication
@RestController
public class WeatherController {
    //one for a specific city (obviously in city available)
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) throws URISyntaxException, JsonProcessingException {
        WeatherService weather = new WeatherService();
        String test = weather.getWeatherForCity(city);
        String jsonString = "{\"coord\":{\"lon\":5.5,\"lat\":43.3333},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":299.11,\"feels_like\":299.11,\"temp_min\":297.12,\"temp_max\":300.25,\"pressure\":1012,\"humidity\":42},\"visibility\":10000,\"wind\":{\"speed\":1.34,\"deg\":104,\"gust\":4.02},\"clouds\":{\"all\":100},\"dt\":1687187834,\"sys\":{\"type\":2,\"id\":80238,\"country\":\"FR\",\"sunrise\":1687147038,\"sunset\":1687202473},\"timezone\":7200,\"id\":2995468,\"name\":\"Arrondissement de Marseille\",\"cod\":200}";

        ObjectMapper objectMapper = new ObjectMapper();
        Meteo weatherData = objectMapper.readValue(test, Meteo.class);
        System.out.println(weatherData.getName());

        return weather.getWeatherForCity(city);
    }

    //for all city retrieve from db
}
