package com.example.jo.meteo.Service.API;

import com.example.jo.meteo.Service.Serializer.WeatherSerializerInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class WeatherApiService implements WeatherApiInterface{

    @Value("${api.url}")
    private String api_url;

    @Value("${api.key}")
    private String api_key;

    private final WeatherSerializerInterface weatherSerializer;
    public WeatherApiService(WeatherSerializerInterface weatherSerializer) {
        this.weatherSerializer = weatherSerializer;
    }

    private HttpRequest buildRequest(String city) throws URISyntaxException {
        String query = api_url + "?q=" + city + "&appid=" + api_key;
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
    public String getWeatherForCity(String city) throws URISyntaxException, JsonProcessingException {
        HttpRequest request = buildRequest(city);
        String response = sendRequest(request);
        String partialWeatherJson = weatherSerializer.partialWeatherJson(response);
        return partialWeatherJson;
    }

}
