package com.example.jo.country.service;

import com.example.jo.country.persistence.Country;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class APIClient {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public APIClient() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String getCodeToACountry(String country) throws IOException, InterruptedException {
        String uri = "https://restcountries.com/v3.1/name/" + country + "?fields=cca2";
        return sendRequest(uri);
    }

    public List<Country> getCountries() throws IOException, InterruptedException {
        String uri = "https://restcountries.com/v3.1/independent?status=true&fields=name,capital,region,languages,maps,population,flags";
        String countriesJSON = sendRequest(uri);
        List<Country> countries = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(countriesJSON);
            for (JsonNode node : root) {
                Country country = createCountry(node);
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public Country getCountryByCode(String countryCode) throws IOException, InterruptedException {
        String uri = "https://restcountries.com/v3.1/alpha?codes=" + countryCode + "&status=true&fields=name,capital,region,languages,maps,population,flags";
        String countryJSON = sendRequest(uri);
        Country country = null;
        try {
            JsonNode root = objectMapper.readTree(countryJSON);
            for (JsonNode node : root) {
                country = createCountry(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    private String sendRequest(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private Country createCountry(JsonNode node) {
        String name = node.get("name").get("common").asText();
        String region = node.get("region").asText();
        JsonNode languagesJsonNode = node.get("languages");
        String[] languages = new String[languagesJsonNode.size()];
        Iterator<String> fieldNames = languagesJsonNode.fieldNames();
        int i = 0;
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode fieldValue = languagesJsonNode.get(fieldName);
            languages[i++] = fieldValue.asText();
        }
        String maps = node.get("maps").get("googleMaps").asText();
        int population = node.get("population").asInt();
        String flag = node.get("flags").get("png").asText();
        String capital = node.get("capital").get(0).asText();
        return new Country(name, region, languages, maps, population, flag, capital);
    }
}