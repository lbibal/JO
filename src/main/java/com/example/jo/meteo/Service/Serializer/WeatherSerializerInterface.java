package com.example.jo.meteo.Service.Serializer;

import com.example.jo.meteo.Persistence.Meteo;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherSerializerInterface {
    Meteo weatherDeserializer(String weatherJson) throws JsonProcessingException;
    String weatherSerializer(Meteo meteo);
    String partialWeatherJson(String weatherJson) throws JsonProcessingException;
}
