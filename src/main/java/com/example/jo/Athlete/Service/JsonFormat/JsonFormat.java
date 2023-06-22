package com.example.jo.Athlete.Service.JsonFormat;

import com.example.jo.Athlete.Persistence.Athlete;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonFormat implements JsonFormatService{
    @Override
    public String buildAthleteJsonFormat(Athlete ath) throws JSONException {
        var buildJsonAthlete = new JSONObject();
        buildJsonAthlete.put("id",ath.getId().toString());
        buildJsonAthlete.put("name",ath.getName());
        buildJsonAthlete.put("sex",ath.getSex());
        buildJsonAthlete.put("age",ath.getAge());
        buildJsonAthlete.put("height",ath.getHeight());
        buildJsonAthlete.put("team",ath.getTeam());
        buildJsonAthlete.put("sport",ath.getSport());

        return buildJsonAthlete.toString();
    }
    @Override
    public String buildMessageJsonFormat(String message) throws JSONException {
        var buildMessageJson = new JSONObject();
        buildMessageJson.put("message",message);
        return buildMessageJson.toString();
    }
}
