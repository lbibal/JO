package com.example.jo.Athlete.Service;

import org.json.JSONException;

public interface AthleteService {
    String getDetailForAthlete(int id) throws JSONException;
    String getDetailForAllAthletes() throws JSONException;
}
