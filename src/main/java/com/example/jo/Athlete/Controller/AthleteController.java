package com.example.jo.Athlete.Controller;

import com.example.jo.Athlete.Persistence.Athlete;
import com.example.jo.Athlete.Service.AthleteService;
import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.*;

@RestController
public class AthleteController {
    private final AthleteService athleteService;
    public AthleteController(AthleteService athleteService){
        this.athleteService = athleteService;
    }
    @GetMapping("/athlete")
    public String getDetailsAthlete(@RequestParam int id) throws JSONException {
        return athleteService.getDetailForAthlete(id);
    }
    @GetMapping("/athlete/all")
    public String getDetailsAllAthletes() throws JSONException {
        return athleteService.getDetailForAllAthletes();
    }
}
