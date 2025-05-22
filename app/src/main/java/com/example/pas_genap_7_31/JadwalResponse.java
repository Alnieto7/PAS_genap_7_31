package com.example.pas_genap_7_31;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JadwalResponse {
    @SerializedName("events")
    private List<JadwalModel> jadwal;

    public List<JadwalModel> getJadwalLaliga() {
        return jadwal;
    }
}
