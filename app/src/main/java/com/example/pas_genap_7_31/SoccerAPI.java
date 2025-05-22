package com.example.pas_genap_7_31;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SoccerAPI {

    @GET("/api/v1/json/3/search_all_teams.php?l=Spanish%20La%20Liga")
    Call<SoccerResponse> getLaliga(@Query("l") String league);

    @GET("/api/v1/json/3/eventsround.php?id=4335&r=36&s=2024-2025")
    Call<JadwalResponse> getJadwalLaliga(@Query("j") String jadwal1);
}
