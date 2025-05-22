package com.example.pas_genap_7_31;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SoccerResponse {
    @SerializedName("teams")
    private List<TimModel> teams;

    public List<TimModel> getTeams() {
        return teams;
    }
}
