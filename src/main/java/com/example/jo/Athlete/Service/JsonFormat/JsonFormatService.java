package com.example.jo.Athlete.Service.JsonFormat;

import com.example.jo.Athlete.Persistence.Athlete;
import org.json.JSONException;

public interface JsonFormatService {
    String buildMessageJsonFormat(String message) throws JSONException;
    String buildAthleteJsonFormat(Athlete ath) throws JSONException;
}
