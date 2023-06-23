package com.example.jo.Athlete.Service.Impl;

import com.example.jo.Athlete.Persistence.Athlete;
import com.example.jo.Athlete.Persistence.AthleteRepository;
import com.example.jo.Athlete.Service.AthleteService;
import com.example.jo.Athlete.Service.JsonFormat.JsonFormatService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AthleteServiceImpl implements AthleteService{

    public AthleteRepository athRepo;
    public JsonFormatService jsonFormatService;
    public AthleteServiceImpl(AthleteRepository athRepo,
                              JsonFormatService jsonFormatService){
        this.jsonFormatService = jsonFormatService;
        this.athRepo = athRepo;
    }
    public String getDetailForAthlete(int id) throws JSONException {
        Optional<Athlete> athlete = athRepo.findById(id);
        return (athlete.isPresent()) ? jsonFormatService.buildAthleteJsonFormat(athlete.get())
                                    : jsonFormatService.buildMessageJsonFormat("Not in DB");
    }
    public String getDetailForAllAthletes() throws JSONException {
        Iterable<Athlete> listOfAthlete = athRepo.findAll();
        StringBuilder buildJsonAllAthletes = new StringBuilder();
        for(Athlete ath : listOfAthlete){
            buildJsonAllAthletes.append(jsonFormatService.buildAthleteJsonFormat(ath));
        }
        return buildJsonAllAthletes.toString();
    }
}
