package com.example.pas_genap_7_31;

import com.google.gson.annotations.SerializedName;

public class JadwalModel {
    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("strPoster")
    private String strPoster;

    @SerializedName("strHomeTeam")
    private String strHomeTeam;

    @SerializedName("strAwayTeam")
    private String strAwayTeam;

    @SerializedName("strHomeTeamBadge")
    private String strHomeTeamBadge;

    @SerializedName("strAwayTeamBadge")
    private String strAwayTeamBadge;

    @SerializedName("intHomeScore")
    private String intHomeScore;

    @SerializedName("intAwayScore")
    private String intAwayScore;

    @SerializedName("dateEventLocal")
    private String dateEventLocal;

    @SerializedName("strTimeLocal")
    private String strTimeLocal;

    public String getDateEventLocal() {
        return dateEventLocal;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public String getStrAwayTeamBadge() {
        return strAwayTeamBadge;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public String getStrHomeTeamBadge() {
        return strHomeTeamBadge;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public String getStrTimeLocal() {
        return strTimeLocal;
    }
}
