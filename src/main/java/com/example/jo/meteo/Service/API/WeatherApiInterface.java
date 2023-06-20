package com.example.jo.meteo.Service.API;

import java.net.URISyntaxException;

public interface WeatherApiInterface {
    String getWeatherForCity(String city) throws URISyntaxException;
}
