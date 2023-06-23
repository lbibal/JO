package com.example.jo.meteo.Service.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.jo.meteo.Persistence.Entity.Meteo;
import org.springframework.stereotype.Service;

@Service
public class WeatherJsonSerializerService implements WeatherSerializerInterface {
    public Meteo weatherDeserializer(String weatherJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String partialWeatherJson = partialWeatherJson(weatherJson);
        Meteo weatherObject = objectMapper.readValue(partialWeatherJson, Meteo.class);
        return weatherObject;
    }
    public String weatherSerializer(Meteo meteo){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(meteo);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String partialWeatherJson(String weatherJson) throws JsonProcessingException {
        StringBuilder buildPartialWeatherJson = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode coordNode = objectMapper.readTree(weatherJson).get("coord");
        JsonNode weatherNode = objectMapper.readTree(weatherJson).get("weather");
        JsonNode nameNode = objectMapper.readTree(weatherJson).get("name");
        JsonNode sysNode = objectMapper.readTree(weatherJson).get("sys");

        buildPartialWeatherJson.append("{\"coord\":"+coordNode.toString()+",");
        buildPartialWeatherJson.append("\"weather\":"+weatherNode.toString()+",");
        buildPartialWeatherJson.append("\"name\":"+nameNode.toString()+",");
        buildPartialWeatherJson.append("\"sys\":"+sysNode.toString()+"}");

        return buildPartialWeatherJson.toString();
    }

}
