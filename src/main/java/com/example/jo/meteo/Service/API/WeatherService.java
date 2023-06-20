package com.example.jo.meteo.Service.API;

import com.example.jo.meteo.Constant;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {
/*
    public static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    public static final String API_KEY = "384e6cfca66910e9fb4d16d74fff1fc8";
  */private HttpRequest buildRequest(String city) throws URISyntaxException {
        String query = Constant.API_URL + "?q=" + city + "&appid=" + Constant.API_KEY;
        URI uri = new URI(query);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        return request;
    }

    private String sendRequest(HttpRequest request) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getWeatherForCity(String city) throws URISyntaxException {
        HttpRequest request = buildRequest(city);
        String response = sendRequest(request);
        return response;
    }

}
