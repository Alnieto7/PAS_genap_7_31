package com.example.pas_genap_7_31;

import com.google.gson.annotations.SerializedName;


public class TimModel {

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strTeamShort")
    private String strTeamShort;

    @SerializedName("strBadge")
    private String strBadge;

    public String getStrBadge() {
        return strBadge;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }
}
