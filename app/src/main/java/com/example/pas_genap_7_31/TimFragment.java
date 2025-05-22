package com.example.pas_genap_7_31;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimFragment extends Fragment {
    RecyclerView rvTeam;
    TimAdapter teamAdapter;
    ProgressBar pbLoading;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tim, container, false);

        rvTeam = view.findViewById(R.id.rvTeam);
        pbLoading = view.findViewById(R.id.pbLoading);
        rvTeam.setLayoutManager(new LinearLayoutManager(getContext()));

        SoccerAPI api = RetrofitClient.getInstance().create(SoccerAPI.class);
        fetchLaligaTeams(api);

        return view;
    }

    private void fetchLaligaTeams(SoccerAPI api) {
        api.getLaliga("Spanish La Liga").enqueue(new Callback<SoccerResponse>() {
            @Override
            public void onResponse(Call<SoccerResponse> call, Response<SoccerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<TimModel> teams = response.body().getTeams();
                    teamAdapter = new TimAdapter(teams);
                    rvTeam.setAdapter(teamAdapter);
                    rvTeam.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<SoccerResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}
